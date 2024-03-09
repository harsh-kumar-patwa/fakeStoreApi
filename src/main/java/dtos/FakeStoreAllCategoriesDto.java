package dtos;

import lombok.Getter;
import lombok.Setter;
import models.Category;

import java.util.List;

@Getter
@Setter
public class FakeStoreAllCategoriesDto {
    private List<Category> categoryList;
}
