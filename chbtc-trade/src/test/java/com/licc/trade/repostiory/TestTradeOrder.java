package com.licc.trade.repostiory;

import com.google.common.collect.Lists;
import com.licc.btc.chbtcapi.enums.ETradeCurrency;
import com.licc.btc.chbtcapi.enums.ETradeOrderStatus;
import com.licc.trade.domain.ParamConfig;
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
    String list =  tradeOrderRepostiory.getLastPriceByUserIdAndCurrency(1L,ETradeCurrency.LTC_CNY.getValue());
      System.out.println(list);
    }

}
