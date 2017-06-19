package com.licc.trade.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.licc.btc.chbtcapi.enums.ETradeCurrency;
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
public class TestTradeOrderService {
    @Resource
    TradeOrderService tradeOrderService;

    @Test
    public void testListByUserIdAndCurrency() {
        String price = tradeOrderService.getLastPriceByUserIdAndCurrency(1L, ETradeCurrency.LTC_CNY.getValue());
        String price2 = tradeOrderService.getLastPriceByUserIdAndCurrency(1L, ETradeCurrency.LTC_CNY.getValue());

        System.out.println(price);
    }
}
