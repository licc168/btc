package com.licc.btc.chbtcapi.res.account;

/**
 *
 * @author lichangchao
 * @version 1.0.0
 * @date 2017/5/19 10:12
 * @see
 */
public class AccountResult {
    private AccountBase          base;
    private Double               totalAssets;
    private Double               netAssets;
    private AccountBalanceForzen balance;
    private AccountBalanceForzen frozen;
    private AccountP2p           p2p;

    public AccountBase getBase() {
        return base;
    }

    public void setBase(AccountBase base) {
        this.base = base;
    }

    public Double getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(Double totalAssets) {
        this.totalAssets = totalAssets;
    }

    public Double getNetAssets() {
        return netAssets;
    }

    public void setNetAssets(Double netAssets) {
        this.netAssets = netAssets;
    }

    public AccountBalanceForzen getBalance() {
        return balance;
    }

    public void setBalance(AccountBalanceForzen balance) {
        this.balance = balance;
    }

    public AccountBalanceForzen getFrozen() {
        return frozen;
    }

    public void setFrozen(AccountBalanceForzen frozen) {
        this.frozen = frozen;
    }

    public AccountP2p getP2p() {
        return p2p;
    }

    public void setP2p(AccountP2p p2p) {
        this.p2p = p2p;
    }
}
