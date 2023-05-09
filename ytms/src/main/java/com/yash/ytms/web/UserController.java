package com.yash.ytms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ytms.model.User;
import com.yash.ytms.service.UserService;

@RestController
@RequestMapping("/useraccess")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/add-user")
	public ResponseEntity<User> saveEmpoyee(  @RequestBody User user) {
		User addUser = userService.addUser(user);
		return new ResponseEntity<User>(addUser,HttpStatus.CREATED);
	}

	@GetMapping("/get-all-user-details")
	public ResponseEntity<List<User>> getAll() {
		List<User> user = userService.getListOfAllUsers();
		return  ResponseEntity.ok(user);
	}
	

}
