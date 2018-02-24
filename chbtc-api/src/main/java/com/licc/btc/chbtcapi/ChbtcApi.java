package com.licc.btc.chbtcapi;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.licc.btc.chbtcapi.enums.ETradeCurrency;
import com.licc.btc.chbtcapi.req.AccountReq;
import com.licc.btc.chbtcapi.req.CancelOrderReq;
import com.licc.btc.chbtcapi.req.GetOrderReq;
import com.licc.btc.chbtcapi.req.GetOrdersNewReq;
import com.licc.btc.chbtcapi.req.GetUnfinishedOrdersReq;
import com.licc.btc.chbtcapi.req.OrderReq;
import com.licc.btc.chbtcapi.res.order.CancelOrderRes;
import com.licc.btc.chbtcapi.res.order.GetOrderRes;
import com.licc.btc.chbtcapi.res.order.GetOrdersRes;
import com.licc.btc.chbtcapi.res.order.OrderRes;
import com.licc.btc.chbtcapi.res.ticker.TickerApiRes;
import com.licc.btc.chbtcapi.util.BeanMapper;
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

public class ChbtcApi {
    static final ObjectMapper mapper = new ObjectMapper();

    /**
     * 获取行情数据
     *
     * @param tradeCurrency
     * @return
     */
   
    public static TickerApiRes ticker(ETradeCurrency tradeCurrency) {
        String url = OkHttpUtils.attachHttpGetParam(Consts.Chbtc_Data+Consts.Chbtc_Data_Tticker, "market", tradeCurrency.getValue());

        try {
            String res = OkHttpUtils.getStringFromServer(url);
            TickerApiRes tickerApiRes = mapper.readValue(res, TickerApiRes.class);
            return tickerApiRes;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 获取用户信息
     *
     * @param accountReq
     * @return
     */
   
    public static  TickerApiRes getAccountInfo(AccountReq accountReq) {
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
            return null;
        }

    }

    /**
     * 委托买卖订单
     *
     * @param orderReq
     * @return
     */
   
    public static OrderRes order(OrderReq orderReq) {
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
            return null;
        }

    }

    /**
     * 取消委托订单
     *
     * @param cancelOrderReq
     * @return
     */
   
    public static CancelOrderRes cancelOrder(CancelOrderReq cancelOrderReq) {
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
            return null;
        }

    }

    /**
     * 获取订单信息
     *
     * @param getOrderReq
     * @return
     */
   
    public static  GetOrderRes getOrder(GetOrderReq getOrderReq) {
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
            return null;
        }

    }

   
    public static List<GetOrdersRes> getUnfinishedOrdersIgnoreTradeType(GetUnfinishedOrdersReq req) {
        String params = "method=" + Consts.Chbtc_Unfinished_Orders + "&accesskey=" + req.getAccessKey() + "&currency="
                + req.getCurrency().getValue() + "&pageIndex=" + req.getPageIndex() + "&pageSize=" + req.getPageSize();
        String hash = EncryDigestUtil.hmacSign(params, EncryDigestUtil.digest(req.getSecretKey()));
        String url = Consts.Chbtc_Trade + Consts.Chbtc_Unfinished_Orders + "?" + params + "&sign=" + hash + "&reqTime="
                + System.currentTimeMillis();
        try {
            String res = OkHttpUtils.getStringFromServer(url);
            if (StringUtils.isEmpty(res)) {
                return Collections.EMPTY_LIST;
            }
            List<GetOrdersRes> getOrderRes = mapper.readValue(res, List.class);
            return getOrderRes;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }

   
    public static List<GetOrdersRes> getOrdersNew(GetOrdersNewReq req) {
        String params = "method=" + Consts.Chbtc_Get_Orders_New + "&accesskey=" + req.getAccessKey() + "&tradeType="
                + req.getOrderType().getValue() + "&currency=" + req.getCurrency().getValue() + "&pageIndex=" + req.getPageIndex()
                + "&pageSize=" + req.getPageSize();
        String hash = EncryDigestUtil.hmacSign(params, EncryDigestUtil.digest(req.getSecretKey()));
        String url = Consts.Chbtc_Trade + Consts.Chbtc_Get_Orders_New + "?" + params + "&sign=" + hash + "&reqTime="
                + System.currentTimeMillis();
        try {
            String res = OkHttpUtils.get(url, "utf-8");
            if (StringUtils.isEmpty(res)) {
                return Collections.EMPTY_LIST;
            }
            List<Map> getOrderRes = mapper.readValue(res, List.class);
            List<GetOrdersRes> resList = BeanMapper.mapList(getOrderRes, GetOrdersRes.class);
            return resList;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }

}
