package com.licc.btc.chbtcapi.req;

import com.licc.btc.chbtcapi.enums.ETradeCurrency;

/**
 * 取消委托入参
 * 
 * @author lichamgchao
 * @version 1.0.0
 * @date 2017/5/22 13:49
 * @see
 */
public class CancelOrderReq extends AccountReq {
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
