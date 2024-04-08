package com.example.productservicenobita.service;

import com.example.productservicenobita.models.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductServices {
    public List<Product> getProducts();
    public Product getProduct(Long id);

    public void deleteProduct(Long id);

    public List<String> getCategories();
    public List<Product> getLimitedProducts(int limit);
    public List<Product> getSortedProducts(String sort);

}