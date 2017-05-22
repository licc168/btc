package com.licc.trade.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 交易行情表
 *
 * @author lichangchao
 * @version 1.0.0
 * @date 2017/5/17 13:59
 * @see
 */
@Entity
@Table(name = "ticker")
public class Ticker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "currency")
    private String currency;

    @Column(name = "time_long")
    private Long timeLong;

    @Column(name = "time_date")
    private Date timeDate;

    @Column(name = "high")
    private String high;
    @Column(name = "last")
    private String last;;
    @Column(name = "low")
    private String low;
    @Column(name = "vol")
    private String vol;
    @Column(name = "buy")
    private String buy;

    @Column(name = "sell")
    private String sell;


    @Column(name = "create_time")
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getTimeLong() {
        return timeLong;
    }

    public void setTimeLong(Long timeLong) {
        this.timeLong = timeLong;
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

    public Date getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(Date timeDate) {
        this.timeDate = timeDate;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }
}
