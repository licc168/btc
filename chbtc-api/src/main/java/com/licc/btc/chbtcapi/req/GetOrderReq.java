package com.licc.btc.chbtcapi.req;

import com.licc.btc.chbtcapi.enums.ETradeCurrency;

/**
 * 获取委托订单信息入参
 * 
 * @author lichangchao
 * @version 1.0.0
 * @date 2017/5/22 13:58
 * @see
 */
public class GetOrderReq extends AccountReq {
    private String         id;            // 单号
    private ETradeCurrency tradeCurrency; // 币种

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ETradeCurrency getTradeCurrency() {
        return tradeCurrency;
    }

    public void setTradeCurrency(ETradeCurrency tradeCurrency) {
        this.tradeCurrency = tradeCurrency;
    }
}
