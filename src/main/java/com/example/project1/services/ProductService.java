package com.example.project1.services;

import java.util.List;

import com.example.project1.entities.Product;

public interface ProductService {
    List<Product> findAll();

    Product findById(Long productId);

    Product saveProduct(Product product);

    Product updateProduct(Long productId, Product product);

    Product deleteProduct(Long productId);
}
