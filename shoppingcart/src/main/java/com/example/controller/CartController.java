package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.AddCartItemRequest;
import com.example.model.CartItem;
import com.example.model.UpdateQuantityRequest;
import com.example.service.CartService;

@RestController
@RequestMapping("/cart/items")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    
    /**
     * 장바구니 아이템 수량 변경 API
     * 
     * @param id 변경할 장바구니 아이템 ID
     * @param request 변경할 수량 정보를 담은 요청 객체
     */
    @PatchMapping("/{id}")
    public void updateQuantity(@PathVariable Long id, @RequestBody UpdateQuantityRequest request) {
        cartService.updateQuantity(id, request.getQuantity());
    }

    @GetMapping
    public List<CartItem> getCartItems() {
        return cartService.getAllItems(); // 이건 너가 서비스에 구현해야 해!
    }

    @PostMapping
    public void addItemToCart(@RequestBody AddCartItemRequest request) {
        cartService.addCartItem(request.getProductId(), request.getQuantity());
    }
}
