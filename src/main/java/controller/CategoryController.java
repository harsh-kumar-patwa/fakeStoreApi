package controller;

import models.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import services.CategoryServices;

import java.util.ArrayList;
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
