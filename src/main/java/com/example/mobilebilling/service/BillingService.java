package com.example.mobilebilling.service;

import com.example.mobilebilling.exception.CustomException;
import com.example.mobilebilling.persistence.enity.CallRecord;
import com.example.mobilebilling.persistence.enity.User;
import com.example.mobilebilling.persistence.repository.CallRepository;
import com.example.mobilebilling.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static com.example.mobilebilling.constants.Constants.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class BillingService implements BillingServiceImpl {

    private final CallRepository callRecordRepository;
    private final UserRepository userRepository;

    @Override
    public void saveCall(String username, int callDuration) {
        // Use the current timestamp directly instead of converting LocalDateTime to Timestamp
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new CustomException(USER_NAME + username + NOT_FOUND));
        int blockCount = (int) Math.ceil(callDuration / 30000.0); // Convert the result to int directly

        CallRecord call = new CallRecord();
        call.setUser(user);
        call.setCallDuration(callDuration);
        call.setBlockCount(blockCount);
        call.setCreatedAt(LocalDateTime.now());
        call.setCreatedBy(username);
        callRecordRepository.save(call);
    }

    @Override
    public Map<String, Integer> getBilling(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new CustomException(USER_NAME + username + NOT_FOUND));
        List<CallRecord> calls = callRecordRepository.findByUserId(user.getId())
                .orElseThrow(() -> new CustomException(USER_ID_NOT_FOUNT));
        int callCount = calls.size(); // Use int instead of Integer
        int blockCount = calls.stream().mapToInt(CallRecord::getBlockCount).sum();

        // Use Map.ofEntries to create the map directly
        return Map.ofEntries(
                Map.entry(CALL_COUNT, callCount),
                Map.entry(BLOCK_COUNT, blockCount)
        );
    }

}
