package com.harshkumarpatwa.productservice9thmarch.services;

import com.harshkumarpatwa.productservice9thmarch.dtos.FakeStoreAllCategoriesDto;
import com.harshkumarpatwa.productservice9thmarch.dtos.FakeStoreCategoryDto;
import com.harshkumarpatwa.productservice9thmarch.models.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCategoryService implements CategoryServices{

    private RestTemplate restTemplate= new RestTemplate();


    @Override
    public List<Category> getAllCategories() {
        FakeStoreAllCategoriesDto fakeStoreAllCategoriesDto = restTemplate.getForObject(
                "https://fakestoreapi.com/categories/",
                FakeStoreAllCategoriesDto.class
        );
        List<Category> allCategories = new ArrayList<>();
        for(int i =0;i<fakeStoreAllCategoriesDto.getCategoryList().size();i++){
            allCategories.add(fakeStoreAllCategoriesDto.getCategoryList().get(i));
        }
        return allCategories;
    }

    @Override
    public Category getInCategory(String name) {
//        FakeStoreCategoryDto fakeStoreCategoryDto = restTemplate.getForObject(
//                "https://fakestoreapi.com/categories/"+name,
//                FakeStoreCategoryDto.class
//        );
        Category newCategory = new Category(name);
//        newCategory.setId(fakeStoreCategoryDto.getId());
//        newCategory.setName(fakeStoreCategoryDto.getName());
        return newCategory;
    }
}
