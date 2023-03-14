package com.example.mobilebilling.controller;

import com.example.mobilebilling.exception.CustomException;
import com.example.mobilebilling.model.ApiError;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CustomApiExceptionHandlerTest {

    @Mock
    private CustomException customException;

    @Mock
    private ConstraintViolationException constraintViolationException;

    @InjectMocks
    private CustomApiExceptionHandler customApiExceptionHandler;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testHandleCustomException() {
        when(customException.getMessage()).thenReturn("userName : [123] not found");

        ResponseEntity<Object> responseEntity = customApiExceptionHandler.handleCustomException(customException);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals("userName : [123] not found", ((ApiError) responseEntity.getBody()).getMessage());
    }

    @Test
    public void testHandleConstraintViolationExceptionWithUserNameBlankNo1() {
        when(constraintViolationException.getMessage()).thenReturn("getBilling.username: Username cannot be blank");

        ResponseEntity<String> responseEntity = customApiExceptionHandler.handleConstraintViolationException(constraintViolationException);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Username cannot be blank.", responseEntity.getBody());
    }


    @Test
    public void testHandleConstraintViolationExceptionWithUserNameBlankNo2() {
        when(constraintViolationException.getMessage()).thenReturn("recordCallDuration.username: Username cannot be blank");

        ResponseEntity<String> responseEntity = customApiExceptionHandler.handleConstraintViolationException(constraintViolationException);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Username cannot be blank.", responseEntity.getBody());
    }


    @Test
    public void testHandleConstraintViolationExceptionWithMaxUserNameLength() {
        when(constraintViolationException.getMessage()).thenReturn("recordCallDuration.username: Username length cannot exceed 31 characters.");

        ResponseEntity<String> responseEntity = customApiExceptionHandler.handleConstraintViolationException(constraintViolationException);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Username length cannot exceed 31 characters.", responseEntity.getBody());
    }
}
