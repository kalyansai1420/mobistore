package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user =this.userRepository.findByUsername(username);
		if(user == null) {
			log.debug("User not found");
			throw new UsernameNotFoundException("No user found");
		}
		
		return user;
	}

}
