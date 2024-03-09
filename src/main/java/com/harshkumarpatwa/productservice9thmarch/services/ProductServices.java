package com.harshkumarpatwa.productservice9thmarch.services;

import com.harshkumarpatwa.productservice9thmarch.models.Product;

import java.util.List;

public interface ProductServices {
    Product[] getAllProducts();
    Product getSingleProduct(Long id);
    Product addProduct(Product product);
    Product updateProduct(Long id);
    Product deleteProduct(Long id);
}
