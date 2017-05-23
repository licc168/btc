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

    @Query(value = "select  buy_price from trade_order where buy_status in (0,2,3) and  sell_status not in (2,1) and user_id = ?1 and currency = ?2 order by id desc  ",nativeQuery=true)
       List<String> findByUserIdAndCurrency(Long userId, String currency);
}
