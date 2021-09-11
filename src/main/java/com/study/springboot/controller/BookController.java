package com.study.springboot.controller;


import com.study.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("controller")
public class BookController {
    @Autowired
    private BookService bookService;
//
//    @Autowired
//    private BookRepository bookRepository;

    @GetMapping("/books")
    public String getBookList(Model model) {
        model.addAttribute("bookList", bookService.getBookList());
        return "book";
    }
}
