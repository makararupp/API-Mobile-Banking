package com.makaradev.sp4_mybatis.service;

import com.makaradev.sp4_mybatis.model.Category;

import java.util.List;

public interface CategoryService {
     //add new Category
    // Category POJO

    void AddNewCategory(Category category);

    // find all categories
    List<Category> findAll();

    // Delete by Id
    void deleteById(Long id);
}
