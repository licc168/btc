package com.licc.btc.chbtcapi.req;

import com.licc.btc.chbtcapi.enums.ETradeCurrency;
import com.licc.btc.chbtcapi.enums.ETradeOrderType;

/**
 * 委托订单参数
 * 
 * @author lichangchao
 * @version 1.0.0
 * @date 2017/5/22 13:33
 * @see
 */
public class OrderReq extends AccountReq {
    private String          price;         // 订单价格
    private String          amount;        // 订单数量
    private ETradeOrderType tradeOrderType;// 订单类型
    private ETradeCurrency  tradeCurrency; // 币种

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public ETradeOrderType getTradeOrderType() {
        return tradeOrderType;
    }

    public void setTradeOrderType(ETradeOrderType tradeOrderType) {
        this.tradeOrderType = tradeOrderType;
    }

    public ETradeCurrency getTradeCurrency() {
        return tradeCurrency;
    }

    public void setTradeCurrency(ETradeCurrency tradeCurrency) {
        this.tradeCurrency = tradeCurrency;
    }
}
