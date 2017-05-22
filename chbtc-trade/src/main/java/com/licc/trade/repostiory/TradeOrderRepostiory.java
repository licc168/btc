package com.licc.trade.repostiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.licc.trade.domain.TradeOrder;

public interface TradeOrderRepostiory extends JpaRepository<TradeOrder, Long> {
    Long countByUserIdAndCurrencyAndBuyStatusInAndSellStatusNotIn(Long userId, String currency, List<Integer> buyStatus,
            List<Integer> sellStatus);

    List<TradeOrder> findByUserIdAndCurrencyAndBuyStatusAndSellStatus(Long userId, String currency, Integer buyStatus, Integer sellStatus);

    List<TradeOrder> findByUserIdAndCurrencyAndBuyStatusInOrUserIdAndCurrencyAndSellStatusIn(Long userId, String currency, List<Integer> buyStatus, Long id, String cur,List<Integer> sellStatus);

}
