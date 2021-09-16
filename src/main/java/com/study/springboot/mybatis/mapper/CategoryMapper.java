package com.study.springboot.mybatis.mapper;

import com.study.springboot.domain.Category;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CategoryMapper {
//    @Select("SELECT * FROM category")
    List<Category> selectCategories();
}
