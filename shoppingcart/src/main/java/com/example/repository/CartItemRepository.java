package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.CartItem;

/**
 * Repository interface for accessing CartItem entities in the database.
 * Extends JpaRepository to provide basic CRUD (Create, Read, Update, Delete) operations.
 * 
 * - Generic types: <CartItem, Long>
 *   CartItem: the entity class managed by this repository
 *   Long: the type of the primary key of CartItem
 * 
 * Spring Data JPA automatically generates the implementation at runtime.
 * 
 * ---
 * CartItem 엔티티에 대한 데이터베이스 접근을 담당하는 인터페이스입니다.
 * JpaRepository를 상속하여 기본적인 CRUD(생성, 조회, 수정, 삭제) 기능을 제공합니다.
 * 
 * - 제네릭 타입: <CartItem, Long>
 *   CartItem : 이 리포지토리가 다루는 엔티티 클래스
 *   Long     : CartItem 엔티티의 기본키 타입
 * 
 * Spring Data JPA가 실행 시점에 구현체를 자동 생성해 줍니다.
 */
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    
}