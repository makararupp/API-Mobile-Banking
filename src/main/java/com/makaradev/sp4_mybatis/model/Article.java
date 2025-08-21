package com.makaradev.sp4_mybatis.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//required default constructor.
public class Article {
    private Long id;
    private String title;
    private String description;
    private  Category category;
    private Boolean status;

}
