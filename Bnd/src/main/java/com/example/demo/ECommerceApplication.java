package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.helper.UserFoundException;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import com.example.demo.service.UserService;

@SpringBootApplication
public class ECommerceApplication implements CommandLineRunner {
	

	Logger log = LoggerFactory.getLogger(ECommerceApplication.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 try {
		log.debug("starting code");
		
		User user = new User();
		user.setUsername("sai");
		user.setPassword(this.bCryptPasswordEncoder.encode("abc"));
		user.setEmail("abc@gmail.com");
		
		Role role1 = new Role();
		role1.setRoleId(44L);
		role1.setRoleName("Admin");
		
		Set<UserRole> userRoleSet = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setRole(role1);
		userRole.setUser(user);
		
		userRoleSet.add(userRole);
		
		User user1 = this.userService.createUser(user, userRoleSet);
		log.debug(user1.getUsername());
		}
		 catch (UserFoundException e) {
	            e.printStackTrace();


	        }
		
	}
	
	

}
