package com.example.model;

/**
 * 장바구니 수량 변경 요청을 받을 때 사용하는 DTO (Data Transfer Object)
 * 
 * 예: {
 *   "quantity": 3
 * }
 * 
 * 서버에서는 이 값을 받아서 장바구니 아이템의 수량을 수정합니다.
 * 
 * This DTO is used to receive quantity update requests from the client.
 * The client sends a JSON like: { "quantity": 3 }
 */
public class UpdateQuantityRequest {

    // 변경할 수량 (예: 3개로 수정)
    // Quantity to update (e.g. change to 3)
    private int quantity;

    // --- Getter & Setter ---

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}