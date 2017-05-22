package com.licc.btc.chbtcapi.res.account;

/**
 *
 * @author lichangchao
 * @version 1.0.0
 * @date 2017/5/19 10:17
 * @see
 */
public class AccountCurrency {
    private Double amount;
    private String currency;
    private String symbol;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
