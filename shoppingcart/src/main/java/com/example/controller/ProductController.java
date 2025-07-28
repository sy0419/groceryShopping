package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.service.CartService;
import com.example.service.ProductService;

/**
 * ProductController
 * 상품 관련 HTTP 요청을 처리하는 컨트롤러입니다.
 * Handles product-related HTTP requests (add, view, delete, update).
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final CartService cartService;

    // 생성자를 통한 의존성 주입 (Dependency Injection)
    public ProductController(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }

    /**
     * 상품 저장 (POST)
     * Save a new product to the database
     *
     * @param product 저장할 상품 객체 (name, price, description)
     */
    @PostMapping
    public void saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    /**
     * 상품 전체 조회 (GET)
     * Get a list of all products
     *
     * @return DB에 저장된 모든 상품 리스트 반환
     */
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * 상품 삭제 (DELETE)
     * Delete a product by ID
     *
     * @param id 삭제할 상품의 ID
     */
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
    }

    /**
     * 상품 ID를 기반으로 장바구니 수량 변경 (PATCH)
     * 이 메서드는 상품이 아니라 **장바구니의 수량을 수정**합니다.
     * 
     * @param id 수량을 변경할 장바구니 아이템의 ID
     * @param quantity 새로운 수량
     */
    @PatchMapping("/{id}")
    public void updateQuantity(@PathVariable Long id, @RequestBody int quantity) {
        cartService.updateQuantity(id, quantity);
    }
}