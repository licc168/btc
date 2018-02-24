package com.licc.btc.chbtcapi.enums;

public enum ETradeResStatus {
    SUCCESS("1000", "调用成功"),
    GENERAL_ERROR ("1001", "一般错误提示"),
    INTERNAL_ERROR("1002", "内部错误"),
    VERIFICATION_NOT_PASS("1003", "验证不通过"),
    MONEY_PASSWORD_LOCK("1004", "资金安全密码锁定"),
    MONEY_PASSWORD_ERROR("1005", "资金安全密码错误，请确认后重新输入"),
    NAME_VERIFIED_NOT_PASS("1006", "实名认证等待审核或审核不通过"),
    API_IN_MAINTENANCE("1009", "此接口维护中"),

    RMB_NO_MONEY ("2001", "人民币账户余额不足"),
    BTC_NO_MONEY("2002", "比特币账户余额不足"),
    LTC_NO_MONEY("2003", "莱特币账户余额不足"),
    ETH_NO_MONEY("2005", "以太币账户余额不足"),
    ETC_NO_MONEY("2006", "ETC币账户余额不足"),
    BTS_NO_MONEY("2007", "BTS币账户余额不足"),
    ACCOUNT_NO_MONEY("2009", "账户余额不足"),

    ORDER_NOT_FOUND("3001", "挂单没有找到"),
    INVALID_MONEY("3002", "无效的金额"),
    INVALID_QUANTITY("3003", "无效的数量"),
    USER_NOT_EXISTS("3004", "用户不存在"),
    INVALID_PARAM("3005", "无效的参数"),
    INVALID_IP("3006", "无效的IP或与绑定的IP不一致"),
    INVALID_REQ_TIME("3007", "请求时间已失效"),
    TRANSACTION_RECORD_NOT_FOUND("3008", "交易记录没有找到"),

    API_LOCK("4001", "API接口被锁定或未启用"),
    REQ_TOO_OFTEN("4002", "请求过于频繁"),


    ;
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