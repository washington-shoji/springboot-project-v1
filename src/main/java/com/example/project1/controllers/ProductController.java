package com.example.project1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project1.entities.Product;
import com.example.project1.services.impl.ProductServiceImpl;

@RestController
@RequestMapping("product")
public class ProductController {
    private final ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping
    List<Product> getAllProductList() {
        return productService.findAll();
    }

    @GetMapping("/by-id")
    Product getProductById(@RequestParam(value = "id") Long id) {
        return productService.findById(id);
    }

    @PostMapping("/create")
    Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/update")
    Product updateProduct(@RequestParam(value = "id") Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/delete")
    void deleteProduct(@RequestParam(value = "id") Long id) {
        productService.deleteProduct(id);
    }
}
