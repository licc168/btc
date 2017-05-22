package com.licc.trade.repostiory;

import com.licc.trade.domain.Ticker;
import com.licc.trade.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepostiory extends JpaRepository<User, Long> {
   List<User> findByDeleteFlag(Integer deleteFlag);
}
