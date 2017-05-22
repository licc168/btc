package com.licc.btc.chbtcapi.enums;

public enum ETradeResStatus {
    SUCCESS("1000", "调用成功"),;
    private String key;
    private String value;

    ETradeResStatus(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}