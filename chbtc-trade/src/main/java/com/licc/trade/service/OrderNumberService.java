package com.licc.trade.service;

import com.licc.trade.domain.OrderNumber;
import com.licc.trade.repostiory.OrderNumberRepostiory;
import org.hibernate.mapping.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class OrderNumberService {
    @Resource
    OrderNumberRepostiory repostiory;
    @Cacheable(value="guavaCache",key = "#id+#currency")
    public List<OrderNumber> listByUserIdAndCurrency(Long userId, String currency){
        return  repostiory.findByUserIdAndCurrency(userId,currency);
    }
}
