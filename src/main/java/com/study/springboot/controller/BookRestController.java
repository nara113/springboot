package com.study.springboot.controller;

import com.study.springboot.domain.Book;
import com.study.springboot.domain.Category;
import com.study.springboot.mybatis.service.ProductService;
import com.study.springboot.service.BookRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookRestController {

    @Autowired
    private BookRestService bookRestService;

    @Autowired
    private ProductService productService;

    @GetMapping("rest/test")
    public Book getRestBooks() {
        return bookRestService.getRestBook();
    }


    @GetMapping("rest/string")
    public String getString() {
        return "rest test!";
    }

//    @GetMapping("category")
//    public List<Category> getCategory() {
//        return bookRestService.getCategories();
//    }

    @GetMapping("/product")
    public void addProduct() {
        productService.addProduct();
    }


    @GetMapping("/exception")
    public void throwException() throws IllegalAccessException {
        throw new IllegalAccessException("test test!");
    }
}
