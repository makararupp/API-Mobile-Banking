package com.makaradev.sp4_mybatis.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Category {
    private Long id;

    @NotBlank(message = "Category name is not be null..!")
    private String name;
}
