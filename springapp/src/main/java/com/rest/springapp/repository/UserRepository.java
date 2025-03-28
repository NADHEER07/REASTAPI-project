package com.rest.springapp.repository;

import com.rest.springapp.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // ✅ Supports pagination & sorting
    Page<User> findAll(Pageable pageable);

    // ✅ Custom JPA Query: Find users by name (case-insensitive, partial match)
    Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
