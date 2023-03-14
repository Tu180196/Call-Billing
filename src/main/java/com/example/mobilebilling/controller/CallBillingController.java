package com.example.mobilebilling.controller;

import java.util.Map;
import javax.validation.Valid;
import com.example.mobilebilling.model.BillingRequest;
import com.example.mobilebilling.service.BillingService;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/mobile/{username}")
@Validated // validates the path variable
@RequiredArgsConstructor
public class CallBillingController {

    private final BillingService mobileService;


    // POST method would be more appropriate for creating a new record
    // PUT method should be used for idempotent updates
    @PutMapping("/call")
    public ResponseEntity<Void> recordCallDuration(
            @PathVariable @Valid @NotBlank(message = "Username cannot be blank") @Size(max = 31, message = "Username length cannot exceed 31 characters") String username,
            @RequestBody @Valid BillingRequest billingRequest) {
        log.debug("creating new record for user {} with call duration {}", username, billingRequest.getCall_duration());
        mobileService.saveCall(username, billingRequest.getCall_duration());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/billing")
    public ResponseEntity<Map<String, Integer>> getBilling(
            @PathVariable @Valid @NotBlank(message = "Username cannot be blank") @Size(max = 31, message = "Username length cannot exceed 31 characters") String username) {
        log.debug("fetching billing information for user {}", username);
        Map<String, Integer> billingInfo = mobileService.getBilling(username);
        return ResponseEntity.ok(billingInfo);
    }
}