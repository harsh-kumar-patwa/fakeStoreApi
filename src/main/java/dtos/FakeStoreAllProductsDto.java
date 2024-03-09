package dtos;

import lombok.Getter;
import lombok.Setter;
import models.Product;

import java.util.List;

@Getter@Setter
public class FakeStoreAllProductsDto {
    private List<Product> productList;
}
