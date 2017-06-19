package com.licc.btc.chbtcapi.enums;

public enum ETradeCurrency {
    BTC_CNY("btc_cny"), LTC_CNY("ltc_cny"), ETH_CNY("eth_cny"), ETC_CNY("etc_cny"),BTS_CNY("bts_cny");
    private String value;

    ETradeCurrency(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}