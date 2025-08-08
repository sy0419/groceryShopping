package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.exception.NotFoundException;
import com.example.model.Product;
import com.example.repository.ProductRepository;

/**
 * Service class that handles business logic related to products.
 * 
 * 상품 관련 비즈니스 로직을 처리하는 서비스 클래스입니다.
 */
@Service
public class ProductService {
    private final ProductRepository productRepository;

    /**
     * Constructor injection for product repository.
     * 
     * 상품 저장소 의존성 주입 생성자
     * 
     * @param productRepository 상품 저장소
     */
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Save a product entity to the database.
     * 
     * 상품을 데이터베이스에 저장합니다.
     * 
     * @param product 저장할 상품 객체
     * @return 저장된 상품 객체
     */
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Retrieve all products from the database.
     * Logs the count of products retrieved.
     * 
     * 데이터베이스에서 모든 상품을 조회합니다.
     * 조회된 상품 개수를 로그로 출력합니다.
     * 
     * @return 상품 목록 리스트
     */
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        System.out.println("DB에서 조회된 상품 개수: " + products.size());
        return products;
    }

    /**
     * Retrieve a single product by its ID.
     * Returns null if not found.
     * 
     * ID로 상품 하나를 조회합니다.
     * 없으면 null을 반환합니다.
     * 
     * @param id 조회할 상품 ID
     * @return 조회된 상품 또는 null
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Product not found with ID: " + id));
    }

    /**
     * Delete a product by its ID.
     * 
     * ID로 상품을 삭제합니다.
     * 
     * @param id 삭제할 상품 ID
     */
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}

// Service class that figures out the business logic 
// It runs the work where customer(s) request(s).
// Using Repository to connect with database.
// 비즈니스 로직을 처리하는 서비스 클래스
// 사용자가 요청한 작업을 실제로 실행합니다. (ex. 저장, 조회)
// Repository를 사용해 DB와 연동합니다.