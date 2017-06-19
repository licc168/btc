package com.licc.trade.repostiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.licc.trade.domain.User;

public interface UserRepostiory extends JpaRepository<User, Long> {
    List<User> findByDeleteFlag(Integer deleteFlag);
}
