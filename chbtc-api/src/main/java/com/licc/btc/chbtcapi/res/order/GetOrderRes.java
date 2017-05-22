package com.licc.btc.chbtcapi.res.order;

/**
 *
 * @author lichangchao
 * @version 1.0.0
 * @date 2017/5/19 13:14
 * @see
 */
public class GetOrderRes {
    private String  currency;
    private String  fees;
    private String  id;
    private String  price;
    private Integer status;
    private String  total_amount;
    private String  trade_amount;
    private String  trade_price;
    private Long    trade_date;
    private String  trade_money;
    private String  type;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getTrade_amount() {
        return trade_amount;
    }

    public void setTrade_amount(String trade_amount) {
        this.trade_amount = trade_amount;
    }

    public String getTrade_price() {
        return trade_price;
    }

    public void setTrade_price(String trade_price) {
        this.trade_price = trade_price;
    }

    public Long getTrade_date() {
        return trade_date;
    }

    public void setTrade_date(Long trade_date) {
        this.trade_date = trade_date;
    }

    public String getTrade_money() {
        return trade_money;
    }

    public void setTrade_money(String trade_money) {
        this.trade_money = trade_money;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
