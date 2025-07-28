package com.example.model;

/**
 * 장바구니에 상품을 추가할 때 사용하는 요청 객체
 * 
 * This class represents the request body for adding a product to the cart.
 * It contains the product's ID and the quantity to add.
 * 
 * Example JSON:
 * {
 *   "productId": 1,
 *   "quantity": 2
 * }
 */
public class AddCartItemRequest {
    // 추가할 상품의 ID (고유 식별자)
    private Long productId;

    // 추가할 수량
    private int quantity;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }   
}