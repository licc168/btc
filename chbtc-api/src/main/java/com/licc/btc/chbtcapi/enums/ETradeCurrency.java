package com.licc.btc.chbtcapi.enums;

public enum ETradeCurrency {
    ZB_QC("zb_qc"), ZB_USDT("zb_usdt"), ZB_BTC("zb_btc"), BTC_QC("btc_qc"),BTC_USDT("btc_usdt"),BCC_USDT("bcc_usdt");
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