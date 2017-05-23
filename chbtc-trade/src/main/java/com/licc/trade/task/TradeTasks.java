package com.licc.trade.task;

import com.licc.btc.chbtcapi.enums.EDeleteFlag;
import com.licc.btc.chbtcapi.enums.ETradeCurrency;
import com.licc.trade.repostiory.UserRepostiory;
import com.licc.trade.service.TradeService;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.licc.trade.domain.User;



/**
 * 定时获取中国比特币交易网数据
 *
 * @author lichangchao
 * @version 1.0.0
 * @date 2017/5/17 14:05
 * @see
 */
@Component
public class TradeTasks {

  @Resource
  TradeService tradeService;
  @Resource
  UserRepostiory userRepostiory;
  @Scheduled(fixedRate = 2000)
  public void listTrade() {
   List<User> userList =  userRepostiory.findByDeleteFlag(EDeleteFlag.NORMAL.getIntegerCode());
    userList.forEach(user -> {
      tradeService.execute(ETradeCurrency.ETC_CNY,user);
      tradeService.execute(ETradeCurrency.LTC_CNY,user);
      tradeService.execute(ETradeCurrency.ETH_CNY,user);

    });

  }
}
