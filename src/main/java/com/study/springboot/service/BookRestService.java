package com.study.springboot.service;

import com.study.springboot.domain.Book;
import com.study.springboot.domain.Category;
import com.study.springboot.mybatis.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookRestService {
//    @Autowired
//    private CategoryMapper categoryMapper;

    private final RestTemplate restTemplate;

    public BookRestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.rootUri("/rest/test").build();
    }

    public Book getRestBook() {
        return this.restTemplate.getForObject("/rest/test", Book.class);
    }

//    public List<Category> getCategories() {
//        return categoryMapper.selectCategories();
//    }
}
