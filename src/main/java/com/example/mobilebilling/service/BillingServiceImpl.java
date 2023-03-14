package com.example.mobilebilling.service;

import java.util.Map;

public interface BillingServiceImpl {
    void saveCall(String username, int callDuration);
    Map<String, Integer> getBilling(String username);
}
