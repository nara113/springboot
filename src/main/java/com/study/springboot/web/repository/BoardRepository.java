package com.study.springboot.web.repository;

import com.study.springboot.web.domain.Board;
import com.study.springboot.web.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByUser(User user);
}
