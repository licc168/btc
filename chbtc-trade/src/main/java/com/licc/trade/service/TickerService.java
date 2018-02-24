package com.licc.trade.service;

import com.licc.btc.chbtcapi.ChbtcApi;
import com.licc.btc.chbtcapi.enums.ETradeCurrency;
import com.licc.btc.chbtcapi.res.ticker.TickerApiRes;
import com.licc.btc.chbtcapi.util.BeanMapper;
import com.licc.trade.domain.Ticker;
import com.licc.trade.util.TimeUtil;
import java.util.Date;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.licc.trade.repostiory.TickerRepostiory;

/**
 *
 *获取交易行情记录
 * @author lichangchao
 * @version 1.0.0
 * @date 2017/6/19 9:44
 * @see
 */
@Service
@Transactional
public class TickerService {
  @Resource
  TickerRepostiory repostiory;


  public void excute(ETradeCurrency tradeCurrency){
    // 查询当前行情数据
    TickerApiRes tickerApiRes = ChbtcApi.ticker(tradeCurrency);
    if(tickerApiRes!=null) {
     Ticker ticker = BeanMapper.map(tickerApiRes.getTicker(),Ticker.class);
      ticker.setCurrency(tradeCurrency.getValue());
      ticker.setCreateTime(new Date());
      ticker.setTimeLong(tickerApiRes.getDate());
      ticker.setTimeDate(TimeUtil.longToTime(tickerApiRes.getDate()));
      Long count = repostiory.countByCurrencyAndBuyAndSellAndHighAndLowAndLastAndVol(tradeCurrency.getValue(),ticker.getBuy(),ticker.getSell(),ticker.getHigh(),ticker.getLow(),ticker.getLast(),ticker.getVol());
      if(count==0) {
        repostiory.save(ticker);
      }
    }

  }
}
