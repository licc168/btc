package com.licc.trade.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "param_config")
public class ParamConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;

    @Column(name = "currency")
    private String  currency;    // 币种

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "hight_buy_diff")
    private String  hightBuyDiff;     // 最高价与买入价格差

    @Column(name = "sell_buy_diff")
    private String  sellBuyDiff;    // 卖与买的价格差

    @Column(name = "order_sell_diff")
    private String  orderSellDiff;     // 订单价格与卖的价格差

    @Column(name = "max_buy_number")
    private Long maxBuyNumber;// 最大委托笔数

    @Column(name = "buy_number")
    private Long buyNumber;   // 单笔买入个数

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getHightBuyDiff() {
        return hightBuyDiff;
    }

    public void setHightBuyDiff(String hightBuyDiff) {
        this.hightBuyDiff = hightBuyDiff;
    }

    public String getSellBuyDiff() {
        return sellBuyDiff;
    }

    public void setSellBuyDiff(String sellBuyDiff) {
        this.sellBuyDiff = sellBuyDiff;
    }

    public String getOrderSellDiff() {
        return orderSellDiff;
    }

    public void setOrderSellDiff(String orderSellDiff) {
        this.orderSellDiff = orderSellDiff;
    }

    public Long getMaxBuyNumber() {
        return maxBuyNumber;
    }

    public void setMaxBuyNumber(Long maxBuyNumber) {
        this.maxBuyNumber = maxBuyNumber;
    }

    public Long getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(Long buyNumber) {
        this.buyNumber = buyNumber;
    }
}
