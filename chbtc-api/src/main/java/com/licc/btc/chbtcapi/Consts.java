package com.licc.btc.chbtcapi;

public class Consts {

    public static final String Chbtc_Trade             = "https://trade.chbtc.com/api/";
    public static final String Chbtc_Ticker            = "http://api.chbtc.com/data/v1/ticker";

    /*************************** 接口方法 *******************/
    public static final String Chbtc_Trade_Order       = "order";                              // 委托下单
    public static final String Chbtc_Trade_CancelOrder = "cancelOrder";                        // 取消委托
    public static final String Chbtc_Trade_AccountInfo = "getAccountInfo";                     // 获取用户基本信息
    public static final String Chbtc_Trade_GetOrder    = "getOrder";                           // 获取用户基本信息
    public static final String Chbtc_Unfinished_Orders = "getUnfinishedOrdersIgnoreTradeType"; // 获取未成交或部份成交的买单和卖单，每次请求返回pageSize<=100条记录
    public static final String Chbtc_Get_Orders_New    = "getOrdersNew";                       // 获取未成交或部份成交的买单和卖单，每次请求返回pageSize<=100条记录

}
