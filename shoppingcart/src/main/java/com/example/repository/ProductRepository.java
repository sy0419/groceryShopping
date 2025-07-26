package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}

// Item repository where connects with database.
// Entity of Product restore or inquires or delects from database.
// Spring automatically makes the fucation and offer to use them.
// DB와 연결된 상품 저장소
// Product 엔티티를 DB에 저장하거나 조회하거나 삭제할 수 있게 해줍니다.
// 직접 구현 안 해도 Spring이 자동으로 기능을 제공합니다.