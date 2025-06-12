package com.example.jobAppRest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.jobAppRest.Repository.UserRepository;
import com.example.jobAppRest.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	private BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(12);
	
	public User saveUser(User user) {
		user.setPassword(bcrypt.encode(user.getPassword()));
		System.out.println(user.getPassword());
		return userRepo.save(user);
	}
}
