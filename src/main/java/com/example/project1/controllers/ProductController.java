package com.example.project1.controllers;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project1.dto.ProductDto;
import com.example.project1.entities.Product;
import com.example.project1.services.impl.ProductServiceImpl;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductServiceImpl productService;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductController(ProductServiceImpl productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    List<ProductDto> getAllProductList() {
        List<Product> products = productService.findAll();
        return products.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/by-id")
    ProductDto getProductById(@RequestParam(value = "id") Long id) {
        Product product = productService.findById(id);
        return convertToDto(product);
    }

    @PostMapping("/create")
    ProductDto createProduct(@RequestBody ProductDto productDto) {

        Product product = converteToEntity(productDto);
        Product productCreated = productService.saveProduct(product);
        return convertToDto(productCreated);
    }

    @PutMapping("/update")
    ProductDto updateProduct(@RequestParam(value = "id") Long id, @RequestBody ProductDto productDto) {
        if (!Objects.equals(id, productDto.getId())) {
            throw new IllegalArgumentException("Ids don't match");
        }
        Product product = converteToEntity(productDto);
        Product updatedProduct = productService.updateProduct(id, product);
        return convertToDto(updatedProduct);
    }

    @DeleteMapping("/delete")
    void deleteProduct(@RequestParam(value = "id") Long id) {
        productService.deleteProduct(id);
    }

    private ProductDto convertToDto(Product product) {
        ProductDto productRequestDto = modelMapper.map(product, ProductDto.class);
        return productRequestDto;
    }

    private Product converteToEntity(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        return product;
    }

}
