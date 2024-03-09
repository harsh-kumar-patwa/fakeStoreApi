package com.harshkumarpatwa.productservice9thmarch.dtos;

import lombok.Getter;
import lombok.Setter;
import com.harshkumarpatwa.productservice9thmarch.models.Product;

import java.util.List;

@Getter@Setter
public class FakeStoreAllProductsDto {
    private List<Product> productList;
}
