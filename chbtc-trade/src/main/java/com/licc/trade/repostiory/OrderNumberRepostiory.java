package com.licc.trade.repostiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.licc.trade.domain.OrderNumber;

public interface OrderNumberRepostiory extends JpaRepository<OrderNumber, Long> {
    List<OrderNumber> findByUserIdAndCurrency(Long userId, String currency);
}
