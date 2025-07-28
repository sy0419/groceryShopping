package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Spring Boot application.
 * 
 * 스프링 부트 애플리케이션의 메인 진입점 클래스입니다.
 * 이 클래스가 실행되면서 내장 톰캣 서버가 시작되고,
 * 스프링 컨테이너가 초기화됩니다.
 */
@SpringBootApplication
public class ShoppingcartApplication {

    /**
     * Main method to launch the Spring Boot application.
     * 
     * 스프링 부트 애플리케이션을 실행하는 메인 메서드입니다.
     * @param args 명령줄 인자
     */
    public static void main(String[] args) {
        SpringApplication.run(ShoppingcartApplication.class, args);
    }
}