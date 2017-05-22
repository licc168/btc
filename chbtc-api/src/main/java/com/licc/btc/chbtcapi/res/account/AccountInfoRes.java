package com.licc.btc.chbtcapi.res.account;

/**
 * @author lichangchao
 * @version 1.0.0
 * @date 2017/5/19 10:06
 * @see
 */
public class AccountInfoRes {
    private AccountResult result;
    private Integer       limit;

    public AccountResult getResult() {
        return result;
    }

    public void setResult(AccountResult result) {
        this.result = result;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
