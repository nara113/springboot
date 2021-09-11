package com.study.springboot.service;

import com.study.springboot.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public List<Book> getBookList() {
        return null;
    }
}
