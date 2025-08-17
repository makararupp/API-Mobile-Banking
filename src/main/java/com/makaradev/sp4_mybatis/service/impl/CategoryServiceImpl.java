package com.makaradev.sp4_mybatis.service.impl;

import com.makaradev.sp4_mybatis.model.Category;
import com.makaradev.sp4_mybatis.repository.CategoryRepository;
import com.makaradev.sp4_mybatis.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public void AddNewCategory(Category category) {
        categoryRepository.insert(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.select();
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.selectById(id);
    }

    @Override
    public void updateCategoryId(Long id, Category newCategory) {
        newCategory.setId(id);
        categoryRepository.updateCategoryId(newCategory);
    }
}
