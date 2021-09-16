package com.study.springboot.mybatis;

import com.study.springboot.mybatis.mapper.CategoryMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryMapperTest {
    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    void test() {
        System.out.println(categoryMapper.selectCategories());
    }
}
