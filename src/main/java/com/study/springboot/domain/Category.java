package com.study.springboot.domain;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Alias("category")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category {
    private int id;
    private String name;
}
