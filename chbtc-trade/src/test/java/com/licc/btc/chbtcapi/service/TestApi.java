package com.licc.btc.chbtcapi.service;

import com.licc.btc.chbtcapi.enums.ETradeCurrency;
import com.licc.btc.chbtcapi.enums.ETradeOrderType;
import com.licc.btc.chbtcapi.req.GetOrdersNewReq;
import com.licc.btc.chbtcapi.req.GetUnfinishedOrdersReq;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.licc.trade.Application;

/**
 * 测试API
 * 
 * @author lichangchao
 * @version 1.0.0
 * @date 2017/5/24 10:55
 * @see
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class TestApi {
   @Resource
  IChbtcApiService chbtcApiService;
   @Test
   public  void test(){
 /*    GetUnfinishedOrdersReq req = new GetUnfinishedOrdersReq();
     req.setAccessKey("a6cd1f35-189f-48db-bca2-3e819f6e1156");
     req.setSecretKey("ae90cf81-f6d2-4d71-99e2-dae215ac2a89");
     req.setCurrency(ETradeCurrency.ETC_CNY);
     req.setPageIndex(0);
     req.setPageSize(20);
      chbtcApiService.getUnfinishedOrdersIgnoreTradeType(req);*/
     GetOrdersNewReq req1 = new GetOrdersNewReq();
     req1.setAccessKey("a6cd1f35-189f-48db-bca2-3e819f6e1156");
     req1.setSecretKey("ae90cf81-f6d2-4d71-99e2-dae215ac2a89");
     req1.setCurrency(ETradeCurrency.ETC_CNY);
     req1.setOrderType(ETradeOrderType.ORDER_BUY);
     req1.setPageIndex(0);
     req1.setPageSize(20);
     chbtcApiService.getOrdersNew(req1);
   }
}
