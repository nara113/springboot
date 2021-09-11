package com.study.springboot.havi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest(value = "value=test")
@SpringBootTest(properties = {"property.value=propertyTest"})
public class SpringBootTestApplicationTests {
//    @Value("${value}")
//    private String value;

    @Value("${property.value}")
    private String propertyValue;

    @Test
    public void contestLoads() {
//        assertEquals(value, "test");
        assertEquals(propertyValue, "propertyTest");
    }
}
