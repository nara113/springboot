package com.study.springboot;

import com.study.springboot.web.domain.Board;
import com.study.springboot.web.domain.BoardType;
import com.study.springboot.web.domain.User;
import com.study.springboot.web.repository.BoardRepository;
import com.study.springboot.web.repository.UserRepository;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@MapperScan(basePackageClasses = SpringbootApplication.class)
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(UserRepository userRepository, BoardRepository boardRepository) {
        return (args -> {
           User user = userRepository.save(User.builder()
           .name("havi")
           .password("test")
           .email("havi@gmail.com")
           .createdDate(LocalDateTime.now())
           .build());

            IntStream.rangeClosed(1, 200).forEach(index ->
                    boardRepository.save(Board.builder()
                    .title("게시글" + index)
                    .subTitle("순서"+index)
                    .content("콘텐츠")
                    .boardType(BoardType.free)
                    .createdDate(LocalDateTime.now())
                    .updatedDate(LocalDateTime.now())
                    .user(user)
                    .build()));
        });
    }

}
