package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class CartItem{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Product product;
    private int quantity;

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

// The items which is in the cart by customer
// This code shows the structure when user put the item into the cart.
// Based on Product, this code also shows how many of the items into the cart.
// 장바구니에 담긴 상품 항목 (Entity)
// 사용자가 장바구니에 상품을 담았을 때의 구조를 나타냅니다.
// 즉, Product를 참조하면서 "이걸 몇 개 담았는지"를 함께 저장합니다.