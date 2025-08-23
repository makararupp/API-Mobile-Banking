package com.makaradev.sp4_mybatis.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//required default constructor.
public class Article {
    private Long id;

    @NotBlank(message = "tittle is required..!")
    private String title;
    private String thumbnail;
    private String description;
    @NotNull(message = "category is required..!")
    private  Category category;
    private Boolean status;

}
