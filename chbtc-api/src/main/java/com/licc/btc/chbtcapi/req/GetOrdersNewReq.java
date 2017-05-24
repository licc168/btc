package com.licc.btc.chbtcapi.req;

import com.licc.btc.chbtcapi.enums.ETradeCurrency;
import com.licc.btc.chbtcapi.enums.ETradeOrderType;

/**
 (新)获取多个委托买单或卖单，每次请求返回pageSize<100条记录
 *
 * @author Administrator
 * @version 1.0.0
 * @date 2017/5/24 12:15
 * @see
 */
public class GetOrdersNewReq extends AccountReq {
  private Integer        pageIndex;
  private Integer        pageSize;
  private ETradeCurrency currency;
  private ETradeOrderType orderType;
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

  public ETradeOrderType getOrderType() {
    return orderType;
  }

  public void setOrderType(ETradeOrderType orderType) {
    this.orderType = orderType;
  }
}
