package com.study.springboot.domain;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Alias("product")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Product {
    private Long prodId;
    @NonNull private String prodName;
    @NonNull private int prodPrice;
}