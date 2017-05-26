package com.licc.trade.domain;

import javax.persistence.*;

@Entity
@Table(name = "order_number")
public class OrderNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;
    @Column(name = "order_number")
    private Integer  orderNumber;    // 币种

    @Column(name = "currency")
    private String  currency;    // 币种

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "order_type")
    private Integer orderType;

    @Column(name="hight_buy_start")
    private String hightBuyStart;
    @Column(name="hight_buy_end")
    private String hightBuyEnd;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
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

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getHightBuyStart() {
        return hightBuyStart;
    }

    public void setHightBuyStart(String hightBuyStart) {
        this.hightBuyStart = hightBuyStart;
    }

    public String getHightBuyEnd() {
        return hightBuyEnd;
    }

    public void setHightBuyEnd(String hightBuyEnd) {
        this.hightBuyEnd = hightBuyEnd;
    }
}
