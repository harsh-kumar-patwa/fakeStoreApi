package services;

import dtos.FakeStoreAllProductsDto;
import dtos.FakeStoreProductDto;
import models.Category;
import models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductServices{
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Product> getAllProducts() {
        FakeStoreAllProductsDto fakeStoreAllProductsDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/",
                FakeStoreAllProductsDto.class
        );
        List<Product> allProducts = new ArrayList<>();
        for(int i =0;i<fakeStoreAllProductsDto.getProductList().size();i++){
            allProducts.add(fakeStoreAllProductsDto.getProductList().get(i));
        }

        return allProducts;
    }

    @Override
    public Product getSingleProduct(Long id) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/"+id,
                FakeStoreProductDto.class
        );
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setName(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProductDto.getCategory());

        return product;
    }

    @Override
    public Product addProduct(Product product) {

        FakeStoreProductDto newProduct = new FakeStoreProductDto();
        newProduct.setId(product.getId());
        newProduct.setTitle(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
        newProduct.setCategory(product.getCategory().getName());

        restTemplate.postForObject(
                "https://fakestoreapi.com/products/",
                newProduct,
                FakeStoreProductDto.class
        );

        return product;
    }
    public Product updateProduct(Long id, ){

        Product product = getSingleProduct(id);
        FakeStoreProductDto newProduct = new FakeStoreProductDto();
        //update whatever you want
        newProduct.setId(product.getId());
        newProduct.setImage(product.getImageUrl());
        newProduct.setPrice(product.getPrice());
        newProduct.setCategory(product.getCategory().getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setTitle(product.getName());

        // update fields


        restTemplate.put(
                "https:/fakestoreapi.com/product/"+id,newProduct
        );
        return product;
    }
    public Product deleteProduct(Long id){
        Product productToBeDeleted = getSingleProduct(id);
        restTemplate.delete("https://fakestoreapi.com/"+id);

        return productToBeDeleted;
    }

}
