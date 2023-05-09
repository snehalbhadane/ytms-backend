package com.yash.ytms.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.yash.ytms.model.User;

public interface UserService {
	
	public User addUser(User user);
	public List<User> getListOfAllUsers();

}
