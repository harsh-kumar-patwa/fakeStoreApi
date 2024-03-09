package controller;

import models.Product;
import org.springframework.web.bind.annotation.*;
import services.ProductServices;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private ProductServices productService;

    public ProductController(ProductServices productService){
        this.productService=productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return new ArrayList<>();
    }
    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id")Long id){

        return productService.getSingleProduct(id);
    }
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
    @PostMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id")Long id, ){

        return productService.updateProduct(id, );
    }
    @GetMapping("/products/{id}")
    public Product deleteProduct(@PathVariable("id")Long id){
        return productService.deleteProduct(id);
    }

}
