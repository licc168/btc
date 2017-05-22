package com.licc.btc.chbtcapi.enums;

public enum ETradeOrderStatus {
    WAIT(0, "待成交"),
    CANCEL(1, "取消"),
    SUCCESS(2, "调用成功"),
    WAIT_NO(3, "待成交未交易部分"),
    FAIL(4, "委托失敗"),
    BUY_SUCCESS_NO_SELL(5,"买成功未卖");
    private int    key;
    private String value;

    ETradeOrderStatus(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}