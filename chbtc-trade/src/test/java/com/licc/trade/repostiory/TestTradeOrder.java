package com.licc.trade.repostiory;

import com.google.common.collect.Lists;
import com.licc.btc.chbtcapi.enums.ETradeCurrency;
import com.licc.btc.chbtcapi.enums.ETradeOrderStatus;
import com.licc.trade.domain.TradeOrder;
import java.util.List;
import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.licc.trade.Application;

/**
 *
 * @author lichangchao
 * @version 1.0.0
 * @date 2017/5/22 20:19
 * @see
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class TestTradeOrder {
    @Resource
    TradeOrderRepostiory tradeOrderRepostiory;

    @Test
    public void test() {
      List<Integer> buyStatus = Lists
          .newArrayList(ETradeOrderStatus.SUCCESS.getKey());
      List<Integer> sellStatus = Lists.newArrayList(ETradeOrderStatus.WAIT.getKey(), ETradeOrderStatus.BUY_SUCCESS_NO_SELL.getKey(),
          ETradeOrderStatus.WAIT_NO.getKey());
     List<TradeOrder>  list = tradeOrderRepostiory.findByUserIdAndCurrencyAndBuyStatusInOrUserIdAndCurrencyAndSellStatusIn(1L, ETradeCurrency.LTC_CNY.getValue(),buyStatus,1L, ETradeCurrency.LTC_CNY.getValue(),sellStatus);
      System.out.println(list);
    }

}
