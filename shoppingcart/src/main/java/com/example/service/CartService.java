package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.CartItem;
import com.example.model.Product;
import com.example.repository.CartItemRepository;
import com.example.repository.ProductRepository;

/**
 * Service class that handles business logic related to the shopping cart.
 * 
 * 주요 장바구니 관련 비즈니스 로직을 처리하는 서비스 클래스입니다.
 */
@Service
public class CartService {
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    /**
     * Constructor injection for repositories.
     * @param cartItemRepository Repository for cart items
     * @param productRepository Repository for products
     * 
     * 리포지토리 의존성 주입 생성자
     * @param cartItemRepository 장바구니 항목 저장소
     * @param productRepository 상품 저장소
     */
    public CartService(CartItemRepository cartItemRepository, ProductRepository productRepository) {
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
    }

    /**
     * Update the quantity of a cart item by its ID.
     * Throws an exception if the item is not found.
     * 
     * 장바구니 아이템의 수량을 변경합니다.
     * 아이템이 없으면 예외를 던집니다.
     * 
     * @param cartItemId 변경할 장바구니 아이템 ID
     * @param quantity 변경할 수량
     */
    public void updateQuantity(Long cartItemId, int quantity) {
        CartItem cartItem = cartItemRepository.findById(cartItemId)
            .orElseThrow(() -> new RuntimeException("Item not found"));
        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);
    }

    /**
     * Add a new item to the cart with specified product ID and quantity.
     * Throws an exception if the product is not found.
     * 
     * 상품 ID와 수량을 받아 장바구니에 새 아이템을 추가합니다.
     * 상품이 없으면 예외를 던집니다.
     * 
     * @param productId 상품 ID
     * @param quantity 수량
     */
    public void addCartItem(Long productId, int quantity) {
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new RuntimeException("Product not found"));
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);
    }

    /**
     * Retrieve all items currently in the cart.
     * 
     * 현재 장바구니에 담긴 모든 아이템을 조회합니다.
     * 
     * @return 장바구니 아이템 리스트
     */
    public List<CartItem> getAllItems() {
        return cartItemRepository.findAll();
    }
}