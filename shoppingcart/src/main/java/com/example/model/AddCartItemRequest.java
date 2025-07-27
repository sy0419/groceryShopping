package com.example.model;

public class AddCartItemRequest {
    private Long productId;
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

// When client asks the item's id and quantity then server is going to add that item to the cart. (If the item is already there, then quantity is going up.)
// 클라이언트가 상품의 ID와 수량을 전달하면 서버는 해당 상품을 장바구니에 추가함 (기존에 있으면 수량만 증가)