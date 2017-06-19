package com.licc.btc.chbtcapi.service;

import java.util.List;

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

/**
 *
 * @author lichangchao
 * @version 1.0.0
 * @date 2017/5/22 19:49
 * @see
 */
public interface IChbtcApiService {
    /**
     * 获取行情数据
     *
     * @param tradeCurrency
     * @return
     */
    TickerApiRes ticker(ETradeCurrency tradeCurrency);

    /**
     * 获取用户信息
     *
     * @param accountReq
     * @return
     */
    TickerApiRes getAccountInfo(AccountReq accountReq);

    /**
     * 委托买卖订单
     *
     * @param orderReq
     * @return
     */
    OrderRes order(OrderReq orderReq);

    /**
     * 取消委托订单
     *
     * @param cancelOrderReq
     * @return
     */
    CancelOrderRes cancelOrder(CancelOrderReq cancelOrderReq);

    /**
     * 获取订单信息
     *
     * @param getOrderReq
     * @return
     */
    GetOrderRes getOrder(GetOrderReq getOrderReq);

    /**
     * 获取未成交或部份成交的买单和卖单，每次请求返回pageSize<=100条记录
     * 
     * @param req
     * @return
     */
    List<GetOrdersRes> getUnfinishedOrdersIgnoreTradeType(GetUnfinishedOrdersReq req);

    List<GetOrdersRes> getOrdersNew(GetOrdersNewReq req);

}
