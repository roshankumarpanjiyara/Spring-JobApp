package com.example.jobAppRest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobAppRest.model.User;
import com.example.jobAppRest.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("register")
	public User register(@RequestBody User user) {
		userService.saveUser(user);
		return user;
	}
}
