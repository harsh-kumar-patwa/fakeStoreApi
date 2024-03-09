package com.harshkumarpatwa.productservice9thmarch.services;

import com.harshkumarpatwa.productservice9thmarch.models.Category;

import java.util.List;

public interface CategoryServices {

    List<Category> getAllCategories();
    Category getInCategory(String name);
}
