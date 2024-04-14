package com.schmogel.emailsapi.application.web;

import feign.FeignException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<String> handleFeignException(FeignException ex, HttpServletResponse response) {
        response.setStatus(ex.status());
        return ResponseEntity.status(ex.status()).body(ex.getMessage());
    }
}