package com.licc.btc.chbtcapi.req;

import com.licc.btc.chbtcapi.enums.ETradeCurrency;
import com.licc.btc.chbtcapi.req.AccountReq;

/**
 * 获取未成交或部份成交的买单和卖单，每次请求返回pageSize<=100条记录 请求参数
 * 
 * @author lichangchao
 * @version 1.0.0
 * @date 2017/5/24 10:37
 * @see
 */
public class GetUnfinishedOrdersReq extends AccountReq {
    private Integer        pageIndex;
    private Integer        pageSize;
    private ETradeCurrency currency;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public ETradeCurrency getCurrency() {
        return currency;
    }

    public void setCurrency(ETradeCurrency currency) {
        this.currency = currency;
    }
}
