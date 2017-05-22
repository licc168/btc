package com.licc.btc.chbtcapi.req;

/**
 * 请求的账号参数
 * 
 * @author lichangchao
 * @version 1.0.0
 * @date 2017/5/22 13:10
 * @see
 */
public class AccountReq {
    private String accessKey;
    private String secretKey;

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
