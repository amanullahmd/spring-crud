package com.spring.spring_crud.repository;

import com.spring.spring_crud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for the User entity.
 * Extends JpaRepository to provide CRUD operations and additional JPA functionalities.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    // No additional methods are required as JpaRepository provides all the necessary CRUD operations
}
