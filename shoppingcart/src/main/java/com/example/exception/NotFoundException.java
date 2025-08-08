package com.example.exception;

/**
 * NotFoundException은 리소스(상품, 장바구니 아이템 등)를 찾지 못했을 때 던지는
 * 커스텀 런타임 예외 클래스입니다.
 *
 * 이 예외를 던지면 Spring의 전역 예외 처리기에서 잡아서
 * 404 Not Found 상태 코드와 함께 사용자에게 의미 있는 메시지를 응답할 수 있습니다.
 *
 * RuntimeException을 상속하기 때문에 별도의 예외 처리 없이도
 * 메서드 선언부에 throws를 명시하지 않아도 됩니다.
 */
public class NotFoundException extends RuntimeException {

    /**
     * 예외 메시지를 받아서 상위 RuntimeException 생성자에 전달합니다.
     * 
     * @param message 예외 상황에 대한 설명 메시지
     */
    public NotFoundException(String message) {
        super(message);
    }
}