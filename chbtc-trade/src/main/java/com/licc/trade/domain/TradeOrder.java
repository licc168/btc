package com.licc.trade.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trade_order")
public class TradeOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "currency")
    private String currency;

    @Column(name = "buy_number")
    private String buyNumber;
    @Column(name = "buy_order_id")
    private String buyOrderId;
    @Column(name = "buy_price")
    private String buyPrice;
    @Column(name = "buy_fees")
    private String buyFees;
    //status : 买单状态(0：待成交,1：取消,2：交易完成)
    @Column(name = "buy_status")
    private Integer buyStatus;
    @Column(name = "sell_order_id")
    private String sellOrderId;
    @Column(name = "sell_price")
    private String sellPrice;
    @Column(name = "sell_fees")
    private String sellFees;
    //status : 卖单状态(0：待成交,1：取消,2：交易完成，4：委托失敗)
    @Column(name = "sell_status")
    private Integer sellStatus;
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "subtract_price")
    private String subtractPrice;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(String buyNumber) {
        this.buyNumber = buyNumber;
    }

    public String getBuyOrderId() {
        return buyOrderId;
    }

    public void setBuyOrderId(String buyOrderId) {
        this.buyOrderId = buyOrderId;
    }

    public String getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(String buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getBuyFees() {
        return buyFees;
    }

    public void setBuyFees(String buyFees) {
        this.buyFees = buyFees;
    }



    public String getSellOrderId() {
        return sellOrderId;
    }

    public void setSellOrderId(String sellOrderId) {
        this.sellOrderId = sellOrderId;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getSellFees() {
        return sellFees;
    }

    public void setSellFees(String sellFees) {
        this.sellFees = sellFees;
    }

    public Integer getBuyStatus() {
        return buyStatus;
    }

    public void setBuyStatus(Integer buyStatus) {
        this.buyStatus = buyStatus;
    }

    public Integer getSellStatus() {
        return sellStatus;
    }

    public void setSellStatus(Integer sellStatus) {
        this.sellStatus = sellStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSubtractPrice() {
        return subtractPrice;
    }

    public void setSubtractPrice(String subtractPrice) {
        this.subtractPrice = subtractPrice;
    }
}
