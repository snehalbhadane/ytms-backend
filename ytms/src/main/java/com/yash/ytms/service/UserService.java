package com.yash.ytms.service;

import java.util.List;

import com.yash.ytms.dto.ServerResponse;
import com.yash.ytms.exception.UserNotFound;
import com.yash.ytms.model.TrainerTask;
import com.yash.ytms.model.User;

public interface UserService {
	
	public User addUser(User user);
	public List<User> getListOfAllUsers();
	public ServerResponse generateToken(String email,String password) throws UserNotFound;
	
	public User getById(Long userId);
	
	public User updateUserById(Long userId,User user);
}
