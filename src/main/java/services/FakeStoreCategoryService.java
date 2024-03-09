package services;

import dtos.FakeStoreAllCategoriesDto;
import dtos.FakeStoreCategoryDto;
import models.Category;
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
        FakeStoreCategoryDto fakeStoreCategoryDto = restTemplate.getForObject(
                "https://fakestoreapi.com/categories/"+name,
                FakeStoreCategoryDto.class
        );
        Category newCategory = new Category();
        newCategory.setId(fakeStoreCategoryDto.getId());
        newCategory.setName(fakeStoreCategoryDto.getName());
        return newCategory;
    }
}
