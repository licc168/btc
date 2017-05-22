package com.licc.btc.chbtcapi.service;

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
import java.io.IOException;

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
  public TickerApiRes ticker(ETradeCurrency tradeCurrency);


  /**
   * 获取用户信息
   *
   * @param accountReq
   * @return
   */
  public TickerApiRes getAccountInfo(AccountReq accountReq) ;

  /**
   * 委托买卖订单
   *
   * @param orderReq
   * @return
   */
  public OrderRes order(OrderReq orderReq);

  /**
   * 取消委托订单
   *
   * @param cancelOrderReq
   * @return
   */
  public CancelOrderRes cancelOrder(CancelOrderReq cancelOrderReq);

  /**
   * 获取订单信息
   *
   * @param getOrderReq
   * @return
   */
  public GetOrderRes getOrder(GetOrderReq getOrderReq);
}
