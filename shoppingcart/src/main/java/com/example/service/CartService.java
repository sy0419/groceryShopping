package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.CartItem;
import com.example.model.Product;
import com.example.repository.CartItemRepository;
import com.example.repository.ProductRepository;

@Service
public class CartService {
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    public CartService(CartItemRepository cartItemRepository, ProductRepository productRepository) {
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
    }

    public void updateQuantity(Long cartItemId, int quantity) {
        CartItem cartItem = cartItemRepository.findById(cartItemId)
            .orElseThrow(() -> new RuntimeException("Item not found"));
        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);
    }

    public void AddCartItem(Long productId, int quantity) {
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new RuntimeException("Product not found"));
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);
    }
}
