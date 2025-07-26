package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Product;
import com.example.repository.ProductRepository;


@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}

// Service class that figure the business logic 
// It runs the works where customer(s) request(s).
// Using Repository to connect with database.
// 비즈니스 로직을 처리하는 서비스 클래스
// 사용자가 요청한 작업을 실제로 실행합니다. (ex. 저장, 조회)
// Repository를 사용해 DB와 연동합니다.