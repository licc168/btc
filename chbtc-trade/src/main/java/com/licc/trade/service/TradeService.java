package com.licc.trade.service;

import com.licc.btc.chbtcapi.enums.ETradeResStatus;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.licc.btc.chbtcapi.enums.ETradeCurrency;
import com.licc.btc.chbtcapi.enums.ETradeOrderStatus;
import com.licc.btc.chbtcapi.enums.ETradeOrderType;
import com.licc.btc.chbtcapi.req.OrderReq;
import com.licc.btc.chbtcapi.res.order.OrderRes;
import com.licc.btc.chbtcapi.res.ticker.TickerApiRes;
import com.licc.btc.chbtcapi.service.ChbtcApiService;
import com.licc.trade.domain.ParamConfig;
import com.licc.trade.domain.TradeOrder;
import com.licc.trade.domain.User;
import com.licc.trade.repostiory.ParamConfigRepostiory;
import com.licc.trade.repostiory.TradeOrderRepostiory;
import com.licc.trade.util.TradeUtil;

/**
 * 自动买卖订单主逻辑
 * 
 * @author lichangchao
 * @version 1.0.0
 * @date 2017/5/22 15:06
 * @see
 */
public class TradeService {
    Logger                logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    ParamConfigRepostiory configRepostiory;
    @Resource
    TradeOrderRepostiory  tradeOrderRepostiory;

    @Resource
    ChbtcApiService       apiService;

    /**
     * @param tradeCurrency 币种类型
     * @param user 用户
     */
    public void execute(ETradeCurrency tradeCurrency, User user) {
        // 根据币种和用户查询配置信息
        ParamConfig config = configRepostiory.findOneByUserIdAndCurrency(user.getId(), tradeCurrency.getValue());
        // 查询当前行情数据
        TickerApiRes tickerApiRes = apiService.ticker(tradeCurrency);

        // 查询委托买入成功 但是未卖出的订单
        List<TradeOrder> tradeOrders = tradeOrderRepostiory.findByUserIdAndCurrencyAndBuyStatusAndSellStatus(user.getId(),
                tradeCurrency.getValue(), ETradeOrderStatus.SUCCESS.getKey(), ETradeOrderStatus.BUY_SUCCESS_NO_SELL.getKey());
        tradeOrders.stream().forEach(tradeOrder -> {
            // 当前卖出价格大于订单买入价格
        });

        // 根据币种和用户查询待成交的委托订单数量
        List<Integer> buyStatus = Lists.newArrayList(ETradeOrderStatus.SUCCESS.getKey());
        List<Integer> sellStatus = Lists.newArrayList(ETradeOrderStatus.SUCCESS.getKey());
        Long sellNum = tradeOrderRepostiory.countByUserIdAndCurrencyAndBuyStatusInAndSellStatusNotIn(user.getId(), tradeCurrency.getValue(),
                buyStatus, sellStatus);
        // 如果待完成的委托卖出订单数量等于设置的最大委托笔数则不进行买卖交易
        if (sellNum == config.getMaxBuyNumber()) {
            logger.info("用户：" + user.getUserName() + " 币种：" + tradeCurrency.getValue() + "达到了最大卖出委托笔数");
            return;
        }

        // 判断最高值和当前买一价是不是小于设定的值 如果是则不进行买卖交易
        Boolean flag = TradeUtil.diffString(tickerApiRes.getTicker().getHigh(), tickerApiRes.getTicker().getBuy(),
                config.getHightBuyDiff());
        if (!flag) {
            logger.info("用户：" + user.getUserName() + " 币种：" + tradeCurrency.getValue() + "最高价与买入价差值需要大于" + config.getHightBuyDiff());
            return;
        }

        // 判断卖一价和买一价差值
        flag = TradeUtil.diffString(tickerApiRes.getTicker().getSell(), tickerApiRes.getTicker().getBuy(), config.getSellBuyDiff());
        if (!flag) {
            logger.info("用户：" + user.getUserName() + " 币种：" + tradeCurrency.getValue() + "卖一价和买一价差值需要大于" + config.getSellBuyDiff());
            return;
        }

    }







    /**
     * 委托卖单
     * @param tradeCurrency
     * @param user
     * @param config
     * @param tickerApiRes
     */
    public void sellOrder(ETradeCurrency tradeCurrency, User user, ParamConfig config, TickerApiRes tickerApiRes) {

        // 查询委托买入成功 但是未卖出的订单
        List<TradeOrder> tradeOrders = tradeOrderRepostiory.findByUserIdAndCurrencyAndBuyStatusAndSellStatus(user.getId(),
                tradeCurrency.getValue(), ETradeOrderStatus.SUCCESS.getKey(), ETradeOrderStatus.BUY_SUCCESS_NO_SELL.getKey());
        tradeOrders.forEach(tradeOrder -> {
            // 当前卖出价格-订单买入价格 >= 设定的差值 委托买入
            boolean flag = TradeUtil.diffString(tickerApiRes.getTicker().getSell(), tradeOrder.getBuyPrice(), config.getOrderSellDiff());
            if (flag) {
                // 当前卖出价格-随机数
                String sellPrice = TradeUtil.getSellPrice(tickerApiRes.getTicker().getSell());
                OrderReq orderReq = new OrderReq();
                orderReq.setPrice(sellPrice);
                orderReq.setAmount(tradeOrder.getBuyNumber());
                orderReq.setTradeCurrency(tradeCurrency);
                orderReq.setTradeOrderType(ETradeOrderType.ORDER_SELL);
                orderReq.setAccessKey(user.getAccessKey());
                orderReq.setSecretKey(user.getSecretKey());
                OrderRes orderRes = apiService.order(orderReq);
                if(ETradeResStatus.SUCCESS.getKey().equals(orderRes.getCode())){//卖出委托成功
                    tradeOrder.setSellOrderId(orderRes.getId());
                    tradeOrder.setSellStatus(String.valueOf(ETradeOrderStatus.WAIT.getKey()));
                    tradeOrder.setSellPrice(sellPrice);
                    tradeOrder.setBuyFees("0");
                    tradeOrderRepostiory.save(tradeOrder);
                }


            } else {
                logger.info("用户：" + user.getUserName() + " 币种：" + tradeCurrency.getValue() + "当前卖出价格-订单买入价格 <" + config.getOrderSellDiff());

            }

        });

    }
    /**
     * 委托买单
     * @param tradeCurrency
     * @param user
     * @param config
     * @param tickerApiRes
     */
    public void buyOrder(ETradeCurrency tradeCurrency, User user, ParamConfig config, TickerApiRes tickerApiRes) {
        // 判断最高值和当前买一价是不是小于设定的值 如果是则不进行买卖交易
        Boolean flag = TradeUtil.diffString(tickerApiRes.getTicker().getHigh(), tickerApiRes.getTicker().getBuy(),
            config.getHightBuyDiff());
        if (!flag) {
            logger.info("用户：" + user.getUserName() + " 币种：" + tradeCurrency.getValue() + "最高价与买入价差值需要大于" + config.getHightBuyDiff());
            return;
        }

        // 判断卖一价和买一价差值
        flag = TradeUtil.diffString(tickerApiRes.getTicker().getSell(), tickerApiRes.getTicker().getBuy(), config.getSellBuyDiff());
        if (!flag) {
            logger.info("用户：" + user.getUserName() + " 币种：" + tradeCurrency.getValue() + "卖一价和买一价差值需要大于" + config.getSellBuyDiff());
            return;
        }
        //委托买单
        String sellPrice = TradeUtil.getSellPrice(tickerApiRes.getTicker().getSell());
        OrderReq orderReq = new OrderReq();
        orderReq.setPrice(sellPrice);
        orderReq.setAmount(String.valueOf(config.getBuyNumber()));
        orderReq.setTradeCurrency(tradeCurrency);
        orderReq.setTradeOrderType(ETradeOrderType.ORDER_BUY);
        orderReq.setAccessKey(user.getAccessKey());
        orderReq.setSecretKey(user.getSecretKey());
        OrderRes orderRes = apiService.order(orderReq);
        if(ETradeResStatus.SUCCESS.getKey().equals(orderRes.getCode())) {//卖出委托成功
            TradeOrder tradeOrder = new TradeOrder();
            tradeOrder.setBuyNumber(String.valueOf(config.getBuyNumber()));
            tradeOrder.setBuyPrice(TradeUtil.getBuyPrice(tickerApiRes.getTicker().getBuy()));
            tradeOrder.setBuyStatus(String.valueOf(ETradeOrderStatus.WAIT.getKey()));
            tradeOrder.setUserId(user.getId());
            tradeOrder.setCreateTime(new Date());
            tradeOrder.setBuyFees("0");
            tradeOrder.setCurrency(tradeCurrency.getValue());
            tradeOrderRepostiory.save(tradeOrder);
        }

    }
}
