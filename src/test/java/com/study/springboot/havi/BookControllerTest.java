package com.study.springboot.havi;

import com.study.springboot.controller.BookController;
import com.study.springboot.domain.Book;
import com.study.springboot.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.hamcrest.Matchers.contains;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
public class BookControllerTest {
    @Autowired
    private MockMvc mvc;

//    Mock은 실제 autowired 될 객체가 존재해야 함
//    @Mock
    @MockBean
    private BookService bookService;

    @Test
    void Book_MVC_테스트() throws Exception {
        Book book = new Book("Spring Boot Book", LocalDateTime.now());

//      Mokito (given에서 when을 사용하니 헷갈림)
        when(bookService.getBookList()).thenReturn(Collections.singletonList(book));

//      BDDMockito (given -> when -> then 에 좀 더 알맞은 형식, Mokito를 상속받음)
        given(bookService.getBookList()).willReturn(Collections.singletonList(book));

        mvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(view().name("book"))
                .andExpect(model().attributeExists("bookList"))
                .andExpect(model().attribute("bookList", contains(book)));

//      Mokito
        verify(bookService).getBookList();

//      BDDMockito (결국 Mokito의 verify 사용)
        then(bookService).should().getBookList();
    }
}
