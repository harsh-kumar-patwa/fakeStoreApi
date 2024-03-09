package services;

import lombok.Getter;
import lombok.Setter;
import models.Category;

import java.util.List;

public interface CategoryServices {

    List<Category> getAllCategories();
    Category getInCategory(String name);
}
