package com.licc.btc.chbtcapi.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.licc.btc.chbtcapi.Consts;
import com.licc.btc.chbtcapi.enums.ETradeCurrency;
import com.licc.btc.chbtcapi.req.AccountReq;
import com.licc.btc.chbtcapi.req.CancelOrderReq;
import com.licc.btc.chbtcapi.req.GetOrderReq;
import com.licc.btc.chbtcapi.req.OrderReq;
import com.licc.btc.chbtcapi.res.order.CancelOrderRes;
import com.licc.btc.chbtcapi.res.order.GetOrderRes;
import com.licc.btc.chbtcapi.res.order.OrderRes;
import com.licc.btc.chbtcapi.res.ticker.TickerApiRes;
import com.licc.btc.chbtcapi.util.EncryDigestUtil;
import com.licc.btc.chbtcapi.util.OkHttpUtils;

/**
 * 中国比特币交易网 API
 * 
 * @author lichangchao
 * @version 1.0.0
 * @date 2017/5/22 12:21
 * @see
 */
public class ChbtcApiService {
    public static final ObjectMapper mapper = new ObjectMapper();
    private Logger                   logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 获取行情数据
     * 
     * @param tradeCurrency
     * @return
     */
    public TickerApiRes ticker(ETradeCurrency tradeCurrency) {
        String url = OkHttpUtils.attachHttpGetParam(Consts.Chbtc_Ticker, "currency", tradeCurrency.getValue());
        try {
            String res = OkHttpUtils.getStringFromServer(url);
            TickerApiRes tickerApiRes = mapper.readValue(res, TickerApiRes.class);

            return tickerApiRes;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("获取行情接口数据出错");
            return null;
        }

    }

    /**
     * 获取用户信息
     * 
     * @param accountReq
     * @return
     */
    public TickerApiRes getAccountInfo(AccountReq accountReq) {
        String params = "method=" + Consts.Chbtc_Trade_AccountInfo + "&accesskey=" + accountReq.getAccessKey();
        String hash = EncryDigestUtil.hmacSign(params, EncryDigestUtil.digest(accountReq.getSecretKey()));
        String url = Consts.Chbtc_Trade + Consts.Chbtc_Trade_AccountInfo + "?" + params + "&sign=" + hash + "&reqTime="
                + System.currentTimeMillis();
        try {
            String res = OkHttpUtils.getStringFromServer(url);
            TickerApiRes tickerApiRes = mapper.readValue(res, TickerApiRes.class);

            return tickerApiRes;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("获取用户信息出错");
            return null;
        }

    }

    /**
     * 委托买卖订单
     * 
     * @param orderReq
     * @return
     */
    public OrderRes order(OrderReq orderReq) {
        String params = "method=" + Consts.Chbtc_Trade_Order + "&accesskey=" + orderReq.getAccessKey() + "&price=" + orderReq.getPrice()
                + "&amount=" + orderReq.getAmount() + "&tradeType=" + orderReq.getTradeOrderType().getValue() + "&currency="
                + orderReq.getTradeCurrency().getValue();
        String hash = EncryDigestUtil.hmacSign(params, EncryDigestUtil.digest(orderReq.getSecretKey()));
        String url = Consts.Chbtc_Trade + Consts.Chbtc_Trade_Order + "?" + params + "&sign=" + hash + "&reqTime="
                + System.currentTimeMillis();
        try {
            String res = OkHttpUtils.getStringFromServer(url);
            OrderRes orderRes = mapper.readValue(res, OrderRes.class);
            return orderRes;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("委托买卖订单接口出错");
            return null;
        }

    }

    /**
     * 取消委托订单
     * 
     * @param cancelOrderReq
     * @return
     */
    public CancelOrderRes cancelOrder(CancelOrderReq cancelOrderReq) {
        String params = "method=" + Consts.Chbtc_Trade_CancelOrder + "&accesskey=" + cancelOrderReq.getAccessKey() + "&id="
                + cancelOrderReq.getId() + "&currency=" + cancelOrderReq.getTradeCurrency().getValue();
        String hash = EncryDigestUtil.hmacSign(params, EncryDigestUtil.digest(cancelOrderReq.getSecretKey()));
        String url = Consts.Chbtc_Trade + Consts.Chbtc_Trade_CancelOrder + "?" + params + "&sign=" + hash + "&reqTime="
                + System.currentTimeMillis();
        try {
            String res = OkHttpUtils.getStringFromServer(url);
            CancelOrderRes cancelOrderRes = mapper.readValue(res, CancelOrderRes.class);
            return cancelOrderRes;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("----取消委托订单出错");
            return null;
        }

    }

    /**
     * 获取订单信息
     *
     * @param getOrderReq
     * @return
     */
    public GetOrderRes getOrder(GetOrderReq getOrderReq) {
        String params = "method=" + Consts.Chbtc_Trade_GetOrder + "&accesskey=" + getOrderReq.getAccessKey() + "&id=" + getOrderReq.getId()
                + "&currency=" + getOrderReq.getTradeCurrency().getValue();
        String hash = EncryDigestUtil.hmacSign(params, EncryDigestUtil.digest(getOrderReq.getSecretKey()));
        String url = Consts.Chbtc_Trade + Consts.Chbtc_Trade_GetOrder + "?" + params + "&sign=" + hash + "&reqTime="
                + System.currentTimeMillis();
        try {
            String res = OkHttpUtils.getStringFromServer(url);
            GetOrderRes getOrderRes = mapper.readValue(res, GetOrderRes.class);
            return getOrderRes;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("获取订单信息出错");
            return null;
        }

    }
}
