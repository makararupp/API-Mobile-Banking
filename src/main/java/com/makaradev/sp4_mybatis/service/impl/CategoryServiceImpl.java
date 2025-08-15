package com.makaradev.sp4_mybatis.service.impl;

import com.makaradev.sp4_mybatis.model.Category;
import com.makaradev.sp4_mybatis.repository.CategoryRepository;
import com.makaradev.sp4_mybatis.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public void AddNewCategory(Category category) {
        categoryRepository.insert(category);
    }
}
