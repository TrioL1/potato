package com.example.potato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.potato.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    // Method to find a User by email
    User findByEmail(String email);

    // Method to find Users by name containing a specific keyword
    List<User> findByNameContaining(String keyword);
}
