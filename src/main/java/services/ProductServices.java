package services;

import models.Product;

import java.util.List;

public interface ProductServices {
    List<Product> getAllProducts();
    Product getSingleProduct(Long id);
    Product addProduct(Product product);
    Product updateProduct(Long id);
    Product deleteProduct(Long id);
}
