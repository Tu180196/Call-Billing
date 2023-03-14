package com.example.mobilebilling.controller;

import com.example.mobilebilling.exception.CustomException;
import com.example.mobilebilling.model.ApiError;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import static com.example.mobilebilling.constants.Constants.*;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
@Slf4j
public class CustomApiExceptionHandler {

    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<Object> handleCustomException(CustomException ex) {
        log.error("CustomException occurred: {}", ex.getMessage());
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex.getMessage());
        return ResponseEntity.internalServerError().body(apiError);
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException ex) {
        log.error("ConstraintViolationException occurred: {}", ex.getMessage());
        String message = ex.getMessage();
        if (message.contains("getBilling.username: Username cannot be blank") || message.contains("recordCallDuration.username: Username cannot be blank")) {
            return ResponseEntity.badRequest().body(USER_NAME_BLANK);
        } else {
            return ResponseEntity.badRequest().body(MAX_LENGTH_USER_NAME);
        }
    }

}
