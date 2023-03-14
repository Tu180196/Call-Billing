package com.example.mobilebilling.service;

import com.example.mobilebilling.exception.CustomException;
import com.example.mobilebilling.persistence.enity.CallRecord;
import com.example.mobilebilling.persistence.enity.User;
import com.example.mobilebilling.persistence.repository.CallRepository;
import com.example.mobilebilling.persistence.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.example.mobilebilling.constants.Constants.BLOCK_COUNT;
import static com.example.mobilebilling.constants.Constants.CALL_COUNT;
import static org.mockito.Mockito.*;

public class BillingServiceTest {

    @Mock
    private CallRepository callRepository;

    @Mock
    private UserRepository userRepository;

    private BillingService billingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        billingService = new BillingService(callRepository, userRepository);
    }

    @Test
    void testSaveCall() {
        User user = new User();
        user.setUsername("testuser");
        user.setId(1L);

        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(user));
        when(callRepository.save(any(CallRecord.class))).thenReturn(null);

        billingService.saveCall("testuser", 600);

        verify(userRepository, times(1)).findByUsername("testuser");
        verify(callRepository, times(1)).save(any(CallRecord.class));
    }

    @Test
    void testSaveCallWithInvalidUser() {
        when(userRepository.findByUsername("invaliduser")).thenReturn(Optional.empty());

        Assertions.assertThrows(CustomException.class, () -> billingService.saveCall("invaliduser", 600));

        verify(userRepository, times(1)).findByUsername("invaliduser");
        verify(callRepository, never()).save(any(CallRecord.class));
    }

    @Test
    void testGetBilling() {
        User user = new User();
        user.setUsername("testuser");
        user.setId(1L);

        List<CallRecord> calls = new ArrayList<>();
        CallRecord call1 = new CallRecord();
        call1.setId(1L);
        call1.setUser(user);
        call1.setBlockCount(3);
        calls.add(call1);
        CallRecord call2 = new CallRecord();
        call2.setId(2L);
        call2.setUser(user);
        call2.setBlockCount(2);
        calls.add(call2);

        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(user));
        when(callRepository.findByUserId(1L)).thenReturn(Optional.of(calls));

        Map<String, Integer> billing = billingService.getBilling("testuser");

        Assertions.assertEquals(2, billing.get(CALL_COUNT));
        Assertions.assertEquals(5, billing.get(BLOCK_COUNT));

        verify(userRepository, times(1)).findByUsername("testuser");
        verify(callRepository, times(1)).findByUserId(1L);
    }

    @Test
    void testGetBillingWithInvalidUser() {
        when(userRepository.findByUsername("invaliduser")).thenReturn(Optional.empty());

        Assertions.assertThrows(CustomException.class, () -> billingService.getBilling("invaliduser"));

        verify(userRepository, times(1)).findByUsername("invaliduser");
        verify(callRepository, never()).findByUserId(anyLong());
    }

}
