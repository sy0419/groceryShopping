package com.example.service;

import org.springframework.stereotype.Service;
import com.example.model.CartItem;
import com.example.repository.CartItemRepository;

@Service
public class CartService {
    private final CartItemRepository cartItemRepository;

    public CartService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public void updateQuantity(Long cartItemId, int quantity) {
        CartItem cartItem = cartItemRepository.findById(cartItemId)
            .orElseThrow(() -> new RuntimeException("Item not found"));
        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);
    }
}
