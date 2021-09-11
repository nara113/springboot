package com.study.springboot;

import com.study.springboot.domain.Fruit;
import com.study.springboot.domain.FruitProperty;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringbootApplicationTests {

    @Value("${property.test.name}")
    private String propertyTestName;

    @Value("${propertyTest}")
    private String propertyTest;

    @Value("${propertyTestList}")
    private String[] propertyTestArray;

    @Value("#{'${propertyTestList}'.split(',')}")
    private List<String> propertyTestList;

    @Autowired
    private FruitProperty fruitProperty;


    @Test
    void test() {
        List<Fruit> fruitData = fruitProperty.getList();

        assertEquals(fruitData.get(0).getName(), "banana");
        assertEquals(fruitData.get(0).getColor(), "yellow");
        assertEquals(fruitProperty.getColorName(), "color");
    }

    @Test
    void contextLoads() {
//        junit 5
        assertEquals(propertyTestName, "property depth test");

        assertEquals(propertyTest, "test");

        assertEquals(propertyTestArray[0], "a");
        assertEquals(propertyTestArray[1], "b");

        assertEquals(propertyTestList.get(0), "a");
        assertEquals(propertyTestList.get(1), "b");
////        assertj
//        assertThat(propertyTestName).isEqualTo("property depth test");
//
//        assertEquals(propertyTest, "test");
//
////        junit 4
//        org.junit.Assert.assertThat(propertyTest, is("test"));
    }

}
