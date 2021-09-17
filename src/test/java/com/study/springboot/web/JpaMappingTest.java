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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class JpaMappingTest {
    @Autowired
    UserRepository userRepository;

    @Autowired
    BoardRepository boardRepository;

    @BeforeEach
    void init() {
        User user = userRepository.save(User.builder()
        .name("havi")
        .password("test")
        .email("test@gmail.com")
        .createDate(LocalDateTime.now())
        .build());

        boardRepository.save(Board.builder()
                .title("test")
                .subTitle("sub")
                .content("content")
                .boardType(BoardType.free)
                .createDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .user(user)
                .build());
    }

    @Test
    void 테스트() {
        User user = userRepository.findByEmail("test@gmail.com");

        assertEquals(user.getName(), "havi");
        assertEquals(user.getPassword(), "test");
        assertEquals(user.getEmail(), "test@gmail.com");

        Board board = boardRepository.findByUser(user);
        assertEquals(board.getTitle(), "test");
        assertEquals(board.getSubTitle(), "sub");
        assertEquals(board.getContent(), "content");
        assertEquals(board.getBoardType(), BoardType.free);
    }

}
