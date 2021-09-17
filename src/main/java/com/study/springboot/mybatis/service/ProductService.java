package com.study.springboot.mybatis.service;

import com.study.springboot.domain.Product;
import com.study.springboot.mybatis.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public Product getProductById(Long id) {

        return productMapper.selectProductById(id);
    }

    public List<Product> getAllProducts() {

        return productMapper.selectAllProducts();
    }

    @Transactional
    public void addProduct() {
        productMapper.insertProduct(new Product("쿤달 샴푸", 7900));

        if (1 == 1) {
            throw new IllegalArgumentException("test exception");
        }

        productMapper.insertProduct(new Product("마스크팩", 1000));
    }
}