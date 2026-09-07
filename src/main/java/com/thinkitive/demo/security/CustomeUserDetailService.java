package com.thinkitive.demo.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.thinkitive.demo.entity.User;
import com.thinkitive.demo.repo.UserRepository;
@Service
public class CustomeUserDetailService implements UserDetailsService{
	@Autowired
	private UserRepository userRepository; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> byUsername = userRepository.findByUsername(username);
		if (byUsername.isEmpty()) {
	        throw new UsernameNotFoundException(
	                "User not found with username: " + username
	        );
	    }
		User user = byUsername.get();
		return org.springframework.security.core.userdetails.User.withUsername(user.getUsername()).password(user.getPassword()).roles(user.getRole()).build();
	}
	
}
