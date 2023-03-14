package com.example.mobilebilling.persistence.repository;

import com.example.mobilebilling.persistence.enity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
