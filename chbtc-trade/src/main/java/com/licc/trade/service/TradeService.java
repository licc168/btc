package com.licc.trade.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.google.common.collect.Lists;
import com.licc.btc.chbtcapi.enums.ETradeCurrency;
import com.licc.btc.chbtcapi.enums.ETradeOrderStatus;
import com.licc.btc.chbtcapi.enums.ETradeOrderType;
import com.licc.btc.chbtcapi.enums.ETradeResStatus;
import com.licc.btc.chbtcapi.req.CancelOrderReq;
import com.licc.btc.chbtcapi.req.GetOrderReq;
import com.licc.btc.chbtcapi.req.OrderReq;
import com.licc.btc.chbtcapi.res.order.GetOrderRes;
import com.licc.btc.chbtcapi.res.order.OrderRes;
import com.licc.btc.chbtcapi.res.ticker.TickerApiRes;
import com.licc.btc.chbtcapi.service.IChbtcApiService;
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
@Service
public class TradeService {
    Logger                logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    ParamConfigRepostiory configRepostiory;
    @Resource
    TradeOrderRepostiory  tradeOrderRepostiory;

    @Resource
    IChbtcApiService      chbtcApiService;

    /**
     * @param tradeCurrency 币种类型
     * @param user 用户
     */
    public void execute(ETradeCurrency tradeCurrency, User user) {
        // 根据币种和用户查询配置信息
        ParamConfig config = configRepostiory.findOneByUserIdAndCurrency(user.getId(), tradeCurrency.getValue());
        if (config == null) {
            logger.info("用户：" + user.getUserName() + " 币种：" + tradeCurrency.getValue() + "当前配置为空 请检查配置 ");
            return;
        }
        // 查询当前行情数据
        TickerApiRes tickerApiRes = chbtcApiService.ticker(tradeCurrency);
        // 更新当前订单状态
        updateOrderStatus(tradeCurrency, user, config, tickerApiRes);
        // 卖出委托订单
        sellOrder(tradeCurrency, user, config, tickerApiRes);
        // 买入委托订单
        buyOrder(tradeCurrency, user, config, tickerApiRes);

    }

    public void updateOrderStatus(ETradeCurrency tradeCurrency, User user, ParamConfig config, TickerApiRes tickerApiRes) {
        List<Integer> buyStatus = Lists.newArrayList(ETradeOrderStatus.SUCCESS.getKey(), ETradeOrderStatus.WAIT.getKey(),
                ETradeOrderStatus.WAIT_NO.getKey());
        List<Integer> sellStatus = Lists.newArrayList(ETradeOrderStatus.WAIT.getKey(), ETradeOrderStatus.BUY_SUCCESS_NO_SELL.getKey(),
                ETradeOrderStatus.WAIT_NO.getKey());
        List<TradeOrder> tradeOrders = tradeOrderRepostiory.findByUserIdAndCurrencyAndBuyStatusInOrUserIdAndCurrencyAndSellStatusIn(
                user.getId(), tradeCurrency.getValue(), buyStatus, user.getId(), tradeCurrency.getValue(), sellStatus);
        if (CollectionUtils.isEmpty(tradeOrders)) {
            logger.info("用户：" + user.getUserName() + " 币种：" + tradeCurrency.getValue() + "更新订单状态 》》未完成或者未取消的订单为空 ");
            return;
        }
        tradeOrders.forEach(tradeOrder -> {
            GetOrderReq getOrderReq = new GetOrderReq();
            getOrderReq.setTradeCurrency(tradeCurrency);
            getOrderReq.setAccessKey(user.getAccessKey());
            getOrderReq.setSecretKey(user.getSecretKey());
            // 修改委托买单的状态\
            if (tradeOrder.getBuyOrderId() != null) {
                getOrderReq.setId(tradeOrder.getBuyOrderId());
                // 判断是否超时
                if (System.currentTimeMillis() - tradeOrder.getCreateTime().getTime() >= config.getBuyNumber()) {
                    CancelOrderReq cancelOrderReq = new CancelOrderReq();
                    cancelOrderReq.setId(tradeOrder.getBuyOrderId());
                    cancelOrderReq.setTradeCurrency(tradeCurrency);
                    cancelOrderReq.setAccessKey(user.getAccessKey());
                    cancelOrderReq.setSecretKey(user.getSecretKey());
                    chbtcApiService.cancelOrder(cancelOrderReq);
                    tradeOrder.setBuyStatus(ETradeOrderStatus.CANCEL.getKey());
                    tradeOrderRepostiory.save(tradeOrder);
                } else {
                    GetOrderRes orderRes = chbtcApiService.getOrder(getOrderReq);
                    tradeOrder.setBuyStatus(orderRes.getStatus());
                    tradeOrderRepostiory.save(tradeOrder);
                }
            }
            // 修改委托卖单的状态
            if (tradeOrder.getSellOrderId() != null) {
                getOrderReq.setId(tradeOrder.getSellOrderId());
                GetOrderRes orderRes = chbtcApiService.getOrder(getOrderReq);
                tradeOrder.setBuyStatus(orderRes.getStatus());
                tradeOrderRepostiory.save(tradeOrder);

            }

        });
    }

    /**
     * 委托卖单
     * 
     * @param tradeCurrency
     * @param user
     * @param config
     * @param tickerApiRes
     */
    public void sellOrder(ETradeCurrency tradeCurrency, User user, ParamConfig config, TickerApiRes tickerApiRes) {

        // 查询委托买入成功 但是未卖出的订单
        List<TradeOrder> tradeOrders = tradeOrderRepostiory.findByUserIdAndCurrencyAndBuyStatusAndSellStatus(user.getId(),
                tradeCurrency.getValue(), ETradeOrderStatus.SUCCESS.getKey(), ETradeOrderStatus.BUY_SUCCESS_NO_SELL.getKey());

        if (CollectionUtils.isEmpty(tradeOrders)) {
            logger.info("用户：" + user.getUserName() + " 币种：" + tradeCurrency.getValue() + "委托卖单 》》买单完成 且没有卖单的订单为空 ");
            return;
        }

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
                OrderRes orderRes = chbtcApiService.order(orderReq);
                if (ETradeResStatus.SUCCESS.getKey().equals(orderRes.getCode())) {// 卖出委托成功
                    tradeOrder.setSellOrderId(orderRes.getId());
                    tradeOrder.setSellStatus(ETradeOrderStatus.WAIT.getKey());
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
     * 
     * @param tradeCurrency
     * @param user
     * @param config
     * @param tickerApiRes
     */
    public void buyOrder(ETradeCurrency tradeCurrency, User user, ParamConfig config, TickerApiRes tickerApiRes) {
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
        // 委托买单
        String sellPrice = TradeUtil.getSellPrice(tickerApiRes.getTicker().getSell());
        OrderReq orderReq = new OrderReq();
        orderReq.setPrice(sellPrice);
        orderReq.setAmount(String.valueOf(config.getBuyNumber()));
        orderReq.setTradeCurrency(tradeCurrency);
        orderReq.setTradeOrderType(ETradeOrderType.ORDER_BUY);
        orderReq.setAccessKey(user.getAccessKey());
        orderReq.setSecretKey(user.getSecretKey());
        OrderRes orderRes = chbtcApiService.order(orderReq);
        if (ETradeResStatus.SUCCESS.getKey().equals(orderRes.getCode())) {// 卖出委托成功
            TradeOrder tradeOrder = new TradeOrder();
            tradeOrder.setBuyNumber(String.valueOf(config.getBuyNumber()));
            tradeOrder.setBuyPrice(TradeUtil.getBuyPrice(tickerApiRes.getTicker().getBuy()));
            tradeOrder.setBuyStatus(ETradeOrderStatus.WAIT.getKey());
            tradeOrder.setUserId(user.getId());
            tradeOrder.setCreateTime(new Date());
            tradeOrder.setBuyFees("0");
            tradeOrder.setCurrency(tradeCurrency.getValue());
            tradeOrder.setSellStatus(ETradeOrderStatus.BUY_SUCCESS_NO_SELL.getKey());
            tradeOrderRepostiory.save(tradeOrder);
        }

    }
}
