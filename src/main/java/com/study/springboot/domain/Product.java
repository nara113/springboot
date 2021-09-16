package com.study.springboot.domain;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Alias("product")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    private Long prodId;
    private String prodName;
    private int prodPrice;
}