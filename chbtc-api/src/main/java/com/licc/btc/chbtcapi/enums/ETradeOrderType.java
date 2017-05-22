package com.licc.btc.chbtcapi.enums;

public enum ETradeOrderType {
    ORDER_BUY(1), ORDER_SELL(0);
    private int value;

    ETradeOrderType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}