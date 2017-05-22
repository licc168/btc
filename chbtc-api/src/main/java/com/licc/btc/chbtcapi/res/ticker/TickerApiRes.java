package com.licc.btc.chbtcapi.res.ticker;

/**
 * 中国比特币交易网-行情api返回数据
 * 
 * @author lichangchao
 * @version 1.0.0
 * @date 2017/5/22 11:14
 * @see
 */
public class TickerApiRes {
    private Long      date;
    private TickerRes ticker;

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public TickerRes getTicker() {
        return ticker;
    }

    public void setTicker(TickerRes ticker) {
        this.ticker = ticker;
    }
}
