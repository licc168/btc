package com.licc.btc.chbtcapi.res.order;

/**
 * 取消委托订单
 * 
 * @author lichangchao
 * @version 1.0.0
 * @date 2017/5/22 13:48
 * @see
 */
public class CancelOrderRes {
    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
