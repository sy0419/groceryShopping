package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice  // 전역 예외 처리 클래스 선언
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)  // NotFoundException 예외 처리
    public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
        // HTTP 404 상태 코드와 예외 메시지를 클라이언트에 응답
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    // 추후 다른 예외도 추가 가능
}