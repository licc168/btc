package com.licc.btc.chbtcapi.enums;

public enum ETrade {
    ETC("etc"), LTC("ltc"), ETH("eth");
    private String value;

    ETrade(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}