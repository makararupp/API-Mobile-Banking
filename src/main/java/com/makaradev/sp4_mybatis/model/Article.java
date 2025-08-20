package com.makaradev.sp4_mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Article {
    private Long id;
    private String title;
    private String description;
   // private  Category category;
    private Boolean status;

}
