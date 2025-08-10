# 🛒 GroceryShopping API

Spring Boot 기반의 **쇼핑카트(장바구니) REST API** 프로젝트입니다.  
상품 등록/조회부터 장바구니 CRUD 기능, 예외 처리 및 테스트까지 완비된 간단한 쇼핑 시스템을 구현했습니다.

---

## 📁 프로젝트 구조

com.example  
|  
├── controller  
│   ├── ProductController.java  
│   └── CartController.java  
|  
├── model  
│   ├── Product.java  
│   ├── CartItem.java  
│   ├── AddCartItemRequest.java  
│   └── UpdateQuantityRequest.java  
|  
├── repository  
│   ├── ProductRepository.java  
│   └── CartItemRepository.java  
|  
├── service  
│   ├── ProductService.java  
│   └── CartService.java  
|  
├── exception  
│   ├── NotFoundException.java  
│   └── GlobalExceptionHandler.java  
|  
└── ShoppingcartApplication.java

---

## ✅ 주요 기능

| 기능              | 메서드 & 엔드포인트       | 설명                                |
|------------------|--------------------------|-----------------------------------|
| 상품 등록          | `POST /products`          | 새로운 상품을 등록합니다               |
| 상품 목록 조회       | `GET /products`           | 전체 상품 목록을 조회합니다             |
| 장바구니에 상품 추가  | `POST /cart/items`        | `productId`와 `quantity`로 상품을 장바구니에 추가 |
| 장바구니 조회        | `GET /cart/items`          | 현재 장바구니에 담긴 모든 아이템을 조회    |
| 장바구니 수량 변경    | `PATCH /cart/items/{id}`   | 수량 변경, 0이면 자동으로 삭제 처리      |
| 장바구니 항목 삭제    | `DELETE /cart/items/{id}`  | 특정 장바구니 아이템 삭제              |

---

## ⚠️ 예외 처리

- **NotFoundException**  
  상품 또는 장바구니 항목이 존재하지 않을 경우 발생하는 커스텀 예외입니다.

- **GlobalExceptionHandler**  
  - 404 Not Found → `NotFoundException` 처리  
  - 500 Internal Server Error → 그 외 모든 예외 처리

---

## 🧪 테스트

총 **7가지 시나리오**를 통해 기능을 검증했습니다.

1. 상품 등록  
2. 장바구니에 상품 추가  
3. 장바구니 수량 변경 (0으로 설정 시 자동 삭제)  
4. 장바구니 항목 명시적 삭제  
5. 존재하지 않는 상품 추가 (예외 처리)  
6. 존재하지 않는 장바구니 항목 수량 변경 (예외 처리)  
7. 존재하지 않는 장바구니 항목 삭제 (예외 처리)  

✅ **모두 정상 동작 확인 완료**

---

## 🚀 실행 방법

```bash
# 저장소 클론
git clone https://github.com/sy0419/groceryShopping.git
cd groceryShopping

# Maven 빌드
./mvnw clean install

# 애플리케이션 실행
./mvnw spring-boot:run

#기본 실행 포트
 http://localhost:8080
```
---

## 📌 기타
프론트엔드 연동 또는 추가 기능 확장도 고려 중입니다.

---
