package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

    // 상품 고유 ID (자동 생성됨)
    // Unique ID for each product (auto-generated)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 상품 이름
    // Name of the product
    private String name;

    // 상품 가격
    // Price of the product
    private int price;

    // 상품 설명
    // Description of the product
    private String description;

    // 기본 생성자 (Spring JPA가 내부적으로 사용함)
    // Default constructor (used internally by Spring JPA)
    public Product() {
    }

    // --- Getter & Setter ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}