package com.harshkumarpatwa.productservice9thmarch.dtos;

import lombok.Getter;
import lombok.Setter;
import com.harshkumarpatwa.productservice9thmarch.models.Category;

import java.util.List;

@Getter
@Setter
public class FakeStoreAllCategoriesDto {
    private List<Category> categoryList;
}
