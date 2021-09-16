package com.study.springboot.web;

import com.study.springboot.web.domain.Board;
import com.study.springboot.web.domain.BoardType;
import com.study.springboot.web.domain.User;
import com.study.springboot.web.repository.BoardRepository;
import com.study.springboot.web.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class JpaMappingTest {
    @Autowired
    UserRepository userRepository;

    @Autowired
    BoardRepository boardRepository;

    @BeforeEach
    public void init() {
        User user = userRepository.save(User.builder()
        .name("havi")
        .password("test")
        .email("test@gamil.com")
        .createDate(LocalDateTime.now())
        .build());

        boardRepository.save(Board.builder()
                .title("test")
                .subTitle("sub")
                .content("content")
                .boardType(BoardType.free)
                .createDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build());
    }

    @Test
    public void 테스트() {
        User user = userRepository.findByEmail("test@gamil.com");
        assertEquals(user.getName(), "havi");
    }

}
