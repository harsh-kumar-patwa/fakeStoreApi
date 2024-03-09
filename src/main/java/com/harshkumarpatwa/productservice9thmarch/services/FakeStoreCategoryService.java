package com.harshkumarpatwa.productservice9thmarch.services;

import com.harshkumarpatwa.productservice9thmarch.models.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreCategoryService implements CategoryServices{

    private RestTemplate restTemplate= new RestTemplate();


    @Override
    public String[] getAllCategories() {
        ResponseEntity<String[]> response =
                restTemplate.getForEntity(
                        "https://fakestoreapi.com/products/categories",
                        String[].class);
        String[] allCategories = response.getBody();
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
