package com.example.mobilebilling.controller;

import com.example.mobilebilling.model.BillingRequest;
import com.example.mobilebilling.service.BillingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CallBillingControllerTest {

    @Mock
    private BillingService billingService;

    private CallBillingController controller;

    @BeforeEach
    public void setup() {
        controller = new CallBillingController(billingService);
    }

    @Test
    public void recordCallDuration_returnsCreated() {
        // Arrange
        String username = "tu";
        BillingRequest request = new BillingRequest();
        request.setCall_duration(100);

        // Act
        ResponseEntity<Void> response = controller.recordCallDuration(username, request);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(billingService).saveCall(username, request.getCall_duration());
    }

    @Test
    public void getBilling_returnsBillingInfo() {
        // Arrange
        String username = "tu";
        Map<String, Integer> billingInfo = new HashMap<>();
        billingInfo.put("total_calls", 10);

        when(billingService.getBilling(username)).thenReturn(billingInfo);

        // Act
        ResponseEntity<Map<String, Integer>> response = controller.getBilling(username);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(billingInfo, response.getBody());
        verify(billingService).getBilling(username);
    }
}
