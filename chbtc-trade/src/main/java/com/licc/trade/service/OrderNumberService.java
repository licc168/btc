package com.licc.trade.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.licc.trade.domain.OrderNumber;
import com.licc.trade.repostiory.OrderNumberRepostiory;

@Service
@Transactional
public class OrderNumberService {
    @Resource
    OrderNumberRepostiory repostiory;

    public List<OrderNumber> listByUserIdAndCurrency(Long userId, String currency) {
        return repostiory.findByUserIdAndCurrency(userId, currency);
    }
}
