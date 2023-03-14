package com.example.mobilebilling.exception;

public class CustomException extends RuntimeException {
    private final String message;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }
}