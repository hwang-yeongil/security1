package com.example.securiy1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.securiy1.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
