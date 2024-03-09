package com.harshkumarpatwa.productservice9thmarch.controller;

import com.harshkumarpatwa.productservice9thmarch.models.Category;
import com.harshkumarpatwa.productservice9thmarch.services.CategoryServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class CategoryController {
    private CategoryServices categoryServices;
    CategoryController(CategoryServices categoryServices){
        this.categoryServices=categoryServices;
    }
    @GetMapping("/categories")
    public List<Category> getAllCategories(){

        return categoryServices.getAllCategories();
    }
    @GetMapping("/categories/{categoryName}")
    public Category getInCategory(@PathVariable("categoryName")String categoryName){

        return categoryServices.getInCategory(categoryName);
    }

}
