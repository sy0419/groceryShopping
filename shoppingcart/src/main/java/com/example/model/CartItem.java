package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class CartItem {

    // 장바구니 항목 고유 ID (자동 생성됨)
    // Unique identifier for the cart item (auto-generated)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 어떤 상품인지 연결 (Product와 다대일 관계)
    // Which product is added to the cart (Many-to-One relationship with Product)
    @ManyToOne
    private Product product;

    // 담은 상품 수량
    // How many units of the product the user added
    private int quantity;

    // --- Getter & Setter ---
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}