package com.licc.trade.task;

import com.licc.btc.chbtcapi.enums.EDeleteFlag;
import com.licc.btc.chbtcapi.enums.ETradeCurrency;
import com.licc.trade.domain.Ticker;
import com.licc.trade.domain.User;
import com.licc.trade.service.TickerService;
import com.licc.trade.service.TradeService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 交易行情定时任务
 * @author lichangchao
 * @version 1.0.0
 * @date 2017/6/19 9:56
 * @see
 */
@Component
public class TickerTask {

  @Resource
  TickerService tickerService;
/*  @Scheduled(fixedDelay = 1000)
  public void listTrade() {
     tickerService.excute(ETradeCurrency.LTC_CNY);
    tickerService.excute(ETradeCurrency.ETH_CNY);
    tickerService.excute(ETradeCurrency.BTC_CNY);
    tickerService.excute(ETradeCurrency.ETC_CNY);
    tickerService.excute(ETradeCurrency.BTS_CNY);

  }*/
}
