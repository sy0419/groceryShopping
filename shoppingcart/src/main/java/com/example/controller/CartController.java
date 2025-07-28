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

/**
 * CartController
 * 장바구니 관련 요청을 처리하는 컨트롤러입니다.
 * Handles HTTP requests related to shopping cart operations.
 */
@RestController
@RequestMapping("/cart/items")
public class CartController {

    private final CartService cartService;

    // 생성자를 통한 의존성 주입 (Dependency Injection)
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    /**
     * 장바구니에 상품 추가 (POST)
     * Adds a product to the cart
     *
     * @param request 상품 ID와 수량을 포함하는 요청 객체
     */
    @PostMapping
    public void addItemToCart(@RequestBody AddCartItemRequest request) {
        cartService.addCartItem(request.getProductId(), request.getQuantity());
    }

    /**
     * 장바구니 아이템 목록 조회 (GET)
     * Returns the list of items in the cart
     *
     * @return 장바구니에 담긴 모든 아이템 목록
     */
    @GetMapping
    public List<CartItem> getCartItems() {
        return cartService.getAllItems();
    }

    /**
     * 장바구니 아이템 수량 변경 (PATCH)
     * Updates the quantity of an item in the cart
     *
     * @param id 수량을 변경할 장바구니 아이템의 ID
     * @param request 새로운 수량 정보를 담은 요청 객체
     */
    @PatchMapping("/{id}")
    public void updateQuantity(@PathVariable Long id, @RequestBody UpdateQuantityRequest request) {
        cartService.updateQuantity(id, request.getQuantity());
    }
}