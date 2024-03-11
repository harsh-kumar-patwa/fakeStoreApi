package com.harshkumarpatwa.productservice9thmarch.controller;

import com.harshkumarpatwa.productservice9thmarch.models.Product;
import com.harshkumarpatwa.productservice9thmarch.services.ProductServices;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private ProductServices productService;

    public ProductController(ProductServices productService){
        this.productService=productService;
    }
    @GetMapping("/products/product/{limit}")
    public Product[] getLimitedProducts(@PathVariable("limit") int limit){
        return productService.getLimitedProducts(limit);
    }

    @GetMapping("/products")
    public Product[] getAllProducts(){

        return productService.getAllProducts();
    }
    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id")Long id){

        return productService.getSingleProduct(id);
    }
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
    @PatchMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id")Long id){

        return productService.updateProduct(id);
    }
    @DeleteMapping("/products/{id}")
    public Product deleteProduct(@PathVariable("id")Long id){
        return productService.deleteProduct(id);
    }

}
