package com.study.springboot.mybatis.mapper;

import com.study.springboot.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {
//    TODO 한글 깨짐, xml 파일 mapper랑 같이 두는 방법
//    @Select("SELECT prod_id as prodId,prod_name as prodName,prod_price as prodPrice FROM products WHERE prod_id = #{id}")
    Product selectProductById(long id);
    List<Product> selectAllProducts();
    void insertProduct(Product product);
}
