package com.yash.ytms.service;

import java.util.List;


import com.yash.ytms.exception.UserNotFound;
import com.yash.ytms.model.User;

public interface UserService {
	
	public User addUser(User user);
	public List<User> getListOfAllUsers();
	public User fetchEmailAndPassword(String email,String password) throws UserNotFound;
}
