package com.licc.trade.service;

import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.licc.trade.domain.TradeOrder;
import com.licc.trade.repostiory.TradeOrderRepostiory;

/**
 * Function:(这里用一句话描述这个类的作用)
 *
 * @author lichangchao
 * @version 1.0.0
 * @date 2017/5/31 17:12
 * @see
 */
@Service
@Transactional
public class TradeOrderService {
    @Resource
    TradeOrderRepostiory repostiory;

    @Cacheable(value = "guavaCache", key = "#userId+#currency")
    public String getLastPriceByUserIdAndCurrency(Long userId, String currency) {
        return repostiory.getLastPriceByUserIdAndCurrency(userId, currency);
    }
  @Cacheable(value = "guavaCache", key = "#userId+#currency+#sellStatus+#buyStatus")
  public  List<TradeOrder>   findByUserIdAndCurrencyAndBuyStatusInOrUserIdAndCurrencyAndSellStatusIn(Long userId, String currency,
      List<Integer> buyStatus, Long id, String cur, List<Integer> sellStatus){
    return repostiory.findByUserIdAndCurrencyAndBuyStatusInOrUserIdAndCurrencyAndSellStatusIn(userId,currency,buyStatus,id,cur,sellStatus);
  }
  @CacheEvict(value="guavaCache",key="#order.userId + #order.currency")
  public void save(TradeOrder order) {
        repostiory.save(order);
    }
}
