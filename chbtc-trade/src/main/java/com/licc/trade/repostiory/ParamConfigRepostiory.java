package com.licc.trade.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.licc.trade.domain.ParamConfig;

/**
 * 配置信息
 * 
 * @author lichangchao
 * @version 1.0.0
 * @date 2017/5/22 15:39
 * @see
 */
public interface ParamConfigRepostiory extends JpaRepository<ParamConfig, Long> {
    ParamConfig findOneByUserIdAndCurrencyAndDeleteFlag(Long userId, String currency, Integer deleteFlag);
}
