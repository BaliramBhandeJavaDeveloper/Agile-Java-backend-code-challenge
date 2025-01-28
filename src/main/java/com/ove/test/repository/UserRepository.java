package com.ove.test.repository;

import com.ove.test.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDetails, Long> {
    // Find user by username
    UserDetails findByUsername(String username);
}
