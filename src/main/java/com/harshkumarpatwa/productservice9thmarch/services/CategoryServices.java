package com.harshkumarpatwa.productservice9thmarch.services;

import com.harshkumarpatwa.productservice9thmarch.models.Category;

import java.util.List;

public interface CategoryServices {

    String[] getAllCategories();
    Category getInCategory(String name);
}
