package com.makaradev.sp4_mybatis.controller;

import com.makaradev.sp4_mybatis.model.Category;
import com.makaradev.sp4_mybatis.service.CategoryService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public  String viewCategory(Category category, Model model){
        model.addAttribute("category", category);
        return  "pages/category/cate-main";
    }

    @PostMapping("/save")
    public String  saveCategory(Category category){
       categoryService.AddNewCategory(category);
        return "redirect:/category";
    }
}
