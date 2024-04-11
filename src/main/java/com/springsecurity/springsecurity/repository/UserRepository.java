package com.springsecurity.springsecurity.repository;

import com.springsecurity.springsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
