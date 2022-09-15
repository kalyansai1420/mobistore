package com.example.demo.service;

import java.util.Set;


import com.example.demo.model.User;
import com.example.demo.model.UserRole;

public interface UserService {

	//creating user
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	
	//get username
	public User getUser(String username);
	
	//delete user by id
	public void deleteUser(Long userId);
	
}
