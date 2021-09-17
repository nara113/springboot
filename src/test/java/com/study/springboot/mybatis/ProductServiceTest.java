package com.study.springboot.mybatis;

import com.study.springboot.domain.Product;
import com.study.springboot.mybatis.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void getProductById() {
        Product product = productService.getProductById(1L);
        log.info("product : {}", product);
    }

    @Test
    void getAllProducts() {
        List<Product> products = productService.getAllProducts();
        log.info("products : {}", products);
    }

    @Transactional
    @Test
    public void addProduct() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            productService.addProduct();
        });

    }
}
