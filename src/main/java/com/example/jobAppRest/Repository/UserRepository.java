package com.example.jobAppRest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobAppRest.model.User;


public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsername(String username);
}
