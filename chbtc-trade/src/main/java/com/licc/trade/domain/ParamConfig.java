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

    @Column(name = "buy_over_time")

    private  Long buyOverTime;//买单超时时间


    @Column(name = "down_buy")
    private String  downBuy;//价格降低参数

    @Column(name = "down_buy_enable")
    private Boolean  downBuyEnable;//价格降低参数

    @Column(name = "max_buy_number")
    private Long maxBuyNumber;// 最大委托笔数

    @Column(name = "buy_number")
    private String buyNumber;   // 单笔买入个数



    @Column(name ="delete_flag")
    private Integer deleteFlag;

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

    public String getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(String buyNumber) {
        this.buyNumber = buyNumber;
    }

    public Long getBuyOverTime() {
        return buyOverTime;
    }

    public void setBuyOverTime(Long buyOverTime) {
        this.buyOverTime = buyOverTime;
    }

    public String getDownBuy() {
        return downBuy;
    }

    public void setDownBuy(String downBuy) {
        this.downBuy = downBuy;
    }

    public Boolean getDownBuyEnable() {
        return downBuyEnable;
    }

    public void setDownBuyEnable(Boolean downBuyEnable) {
        this.downBuyEnable = downBuyEnable;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
