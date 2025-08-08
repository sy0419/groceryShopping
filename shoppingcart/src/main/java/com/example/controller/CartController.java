package com.example.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.AddCartItemRequest;
import com.example.model.CartItem;
import com.example.model.UpdateQuantityRequest;
import com.example.service.CartService;

/**
 * CartController
 * 장바구니 관련 요청을 처리하는 컨트롤러입니다.
 * Handles HTTP requests related to shopping cart operations.
 */
@RestController
@RequestMapping("/cart/items")
public class CartController {

    private final CartService cartService;

    // 생성자를 통한 의존성 주입 (Dependency Injection)
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    /**
     * 장바구니에 상품 추가 (POST)
     * Adds a product to the cart
     *
     * @param request 상품 ID와 수량을 포함하는 요청 객체
     */
    @PostMapping
    public ResponseEntity<Void> addItemToCart(@RequestBody AddCartItemRequest request) {
        cartService.addCartItem(request.getProductId(), request.getQuantity());
        return ResponseEntity.status(201).build();
    }

    /**
     * 장바구니 아이템 목록 조회 (GET)
     * Returns the list of items in the cart
     *
     * @return 장바구니에 담긴 모든 아이템 목록
     */
    @GetMapping
    public List<CartItem> getCartItems() {
        return cartService.getAllItems();
    }

    /**
     * 장바구니 아이템 수량 변경 (PATCH)
     * Updates the quantity of an item in the cart
     *
     * @param id 수량을 변경할 장바구니 아이템의 ID
     * @param request 새로운 수량 정보를 담은 요청 객체
     */
    @PatchMapping("/{id}")
    public void updateQuantity(@PathVariable Long id, @RequestBody UpdateQuantityRequest request) {
        cartService.updateQuantity(id, request.getQuantity());
    }

    // [삭제 요청 처리] 클라이언트로부터 DELETE /cart/items/{id} 요청을 받으면 실행됨
    // Handles DELETE request from the client at /cart/items/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id) {
        // [서비스 계층에 삭제 요청 전달] 해당 id의 장바구니 아이템을 삭제하도록 서비스에 위임
        // Delegates the deletion of the cart item with the given ID to the service layer
        cartService.deleteCartItem(id);

        // [204 No Content 응답 반환]
        // 삭제가 정상적으로 완료되었음을 클라이언트에 알리기 위해 HTTP 상태 코드 204(No Content)를 반환함.
        // RESTful API의 관례에 따라, 삭제 성공 시에는 보통 응답 본문 없이 204 상태만 보낸다.
        //
        // Returns 204 No Content to indicate successful deletion with no response body.
        // According to RESTful conventions, a successful DELETE request typically returns 204 with an empty body.

        // [return이 마지막 줄에 있는 이유]
        // 메서드의 반환 타입이 ResponseEntity<Void>이므로 반드시 return이 필요하다.
        // cartService.deleteCartItem()는 void를 반환하므로, 직접 반환값을 만들지 않으면 컴파일 오류가 발생한다.
        // 따라서 마지막 줄에서 ResponseEntity 객체를 명시적으로 만들어서 반환한다.
        //
        // This method must return a ResponseEntity because of its declared return type (ResponseEntity<Void>).
        // Since the service method returns void, the controller must construct and return a ResponseEntity manually.
        return ResponseEntity.noContent().build();
    }
}