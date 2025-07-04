package com.example.jobAppRest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.jobAppRest.Repository.UserRepository;
import com.example.jobAppRest.model.User;
import com.example.jobAppRest.model.UserPrincipal;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepo.findByUsername(username);
		System.out.println(userRepo.findAll());
		if(user == null) {
			System.out.println("User not Found!");
			throw new UsernameNotFoundException("User 404");
		}
		return new UserPrincipal(user);
	}

}
