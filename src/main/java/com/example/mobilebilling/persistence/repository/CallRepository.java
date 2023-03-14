package com.example.mobilebilling.persistence.repository;

import com.example.mobilebilling.persistence.enity.CallRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CallRepository extends JpaRepository<CallRecord, Long> {


    Optional<List<CallRecord>> findByUserId(Long userId);
}

