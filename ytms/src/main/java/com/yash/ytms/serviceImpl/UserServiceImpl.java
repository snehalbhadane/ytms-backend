package com.yash.ytms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.yash.ytms.model.User;
import com.yash.ytms.repo.UserRepository;
import com.yash.ytms.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User addUser(User user) {
		return userRepository.save(user);
		
	}

	@Override
	public List<User> getListOfAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public String fetchEmailAndPasswod(String email, String passwod) {
//		User user=new User();
//		user.setEmail(email);
//		user.setPasswod(password);
//           userRepository.findByEmailAndPassword(email, password).toString();
//	 
//
//	 if(user.getEmail().equals(string) && user.getPasswod().equals(password)) {
//			 
//			 return "login Successfully";
//		 
//		 }
//		 else {
//			 return "Invalid credentinal";
//		 }
		
		return "Hii";
		
	}

}
