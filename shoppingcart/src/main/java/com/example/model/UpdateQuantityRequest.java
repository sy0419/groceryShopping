package com.example.model;

public class UpdateQuantityRequest {
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

// DTO class when client ask quantity modifying, then the Json data mapping the quantity.
// 장바구니 아이템의 수량 변경 요청 시 클라이언트로부터 전달되는 JSON 데이터를 매핑하기 위한 DTO 클래스입니다.