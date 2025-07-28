package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Product;
import com.example.repository.ProductRepository;


@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        System.out.println("DB에서 조회된 상품 개수: " + products.size());
        return products;
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}

// Service class that figure the business logic 
// It runs the works where customer(s) request(s).
// Using Repository to connect with database.
// 비즈니스 로직을 처리하는 서비스 클래스
// 사용자가 요청한 작업을 실제로 실행합니다. (ex. 저장, 조회)
// Repository를 사용해 DB와 연동합니다.