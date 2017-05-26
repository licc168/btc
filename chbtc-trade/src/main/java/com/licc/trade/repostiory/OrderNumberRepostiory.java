package com.licc.trade.repostiory;


import com.licc.trade.domain.OrderNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface  OrderNumberRepostiory extends JpaRepository<OrderNumber, Long> {
      List<OrderNumber> findByUserIdAndCurrency(Long userId, String currency);
}
