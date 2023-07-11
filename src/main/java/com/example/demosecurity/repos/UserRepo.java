package com.example.demosecurity.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demosecurity.domains.User;

public interface UserRepo extends JpaRepository<User, Long>{
    User findByUsername(String username);
}
