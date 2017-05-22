package com.licc.btc.chbtcapi.res.account;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Administrator
 * @version 1.0.0
 * @date 2017/5/19 10:14
 * @see
 */
public class AccountBalanceForzen {
    @JsonProperty("CNY")
    private AccountCurrency CNY;
    @JsonProperty("BTC")
    private AccountCurrency BTC;
    @JsonProperty("LTC")
    private AccountCurrency LTC;
    @JsonProperty("ETH")
    private AccountCurrency ETH;
    @JsonProperty("DAO")
    private AccountCurrency DAO;
    @JsonProperty("ETC")
    private AccountCurrency ETC;

    public AccountCurrency getCNY() {
        return CNY;
    }

    public void setCNY(AccountCurrency CNY) {
        this.CNY = CNY;
    }

    public AccountCurrency getBTC() {
        return BTC;
    }

    public void setBTC(AccountCurrency BTC) {
        this.BTC = BTC;
    }

    public AccountCurrency getLTC() {
        return LTC;
    }

    public void setLTC(AccountCurrency LTC) {
        this.LTC = LTC;
    }

    public AccountCurrency getETH() {
        return ETH;
    }

    public void setETH(AccountCurrency ETH) {
        this.ETH = ETH;
    }

    public AccountCurrency getDAO() {
        return DAO;
    }

    public void setDAO(AccountCurrency DAO) {
        this.DAO = DAO;
    }

    public AccountCurrency getETC() {
        return ETC;
    }

    public void setETC(AccountCurrency ETC) {
        this.ETC = ETC;
    }
}
