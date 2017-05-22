package com.licc.btc.chbtcapi.enums;

public enum EDeleteFlag {
    // 未删除
    NORMAL("0"),
    // 已删除
    DELETED("1");

    /**
     * 0：未删除，1：已删除
     */
    String code;

    EDeleteFlag(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public Integer getIntegerCode() {
        return Integer.valueOf(this.code);
    }

    public Integer getNormalCode() {
        return Integer.valueOf(NORMAL.getCode());
    }
}