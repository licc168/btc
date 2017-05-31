package com.licc.trade.repostiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.licc.trade.domain.TradeOrder;

public interface TradeOrderRepostiory extends JpaRepository<TradeOrder, Long> {
    Long countByUserIdAndCurrencyAndBuyStatusInAndSellStatusNotIn(Long userId, String currency, List<Integer> buyStatus,
            List<Integer> sellStatus);

    List<TradeOrder> findByUserIdAndCurrencyAndBuyStatusAndSellStatus(Long userId, String currency, Integer buyStatus, Integer sellStatus);

    List<TradeOrder> findByUserIdAndCurrencyAndBuyStatusInOrUserIdAndCurrencyAndSellStatusIn(Long userId, String currency,
            List<Integer> buyStatus, Long id, String cur, List<Integer> sellStatus);



 /*   TradeOrder findByBuyOrderIdAndUserId(String buyOrderId,Long userId);

    TradeOrder findBySellOrderIdAndUserId(String sellOrderId,Long userId);*/


    List<TradeOrder> findByUserIdAndCurrencyAndBuyStatusIn(Long userId,String currency,List<Integer> buyStatus);
    @Query(value = "select  buy_price from trade_order where buy_status not in(1) and  sell_status not in(2) and user_id = ?1 and currency = ?2 order by id desc limit 0,1 ", nativeQuery = true)
    String getLastPriceByUserIdAndCurrency(Long userId, String currency);

}
