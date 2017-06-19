package com.licc.trade.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.licc.trade.domain.Ticker;

/**
 * @author lichangchao
 * @version 1.0.0
 * @date 2017/5/22 9:06
 * @see
 */
public interface TickerRepostiory extends JpaRepository<Ticker, Long> {
    Long countByCurrencyAndBuyAndSellAndHighAndLowAndLastAndVol(String currency, String buy, String sell, String high, String low,
            String last, String vol);
}
