package com.app.microservice.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 * It is responsible for performing the actual database operations
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
