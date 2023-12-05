package com.yash.ytms.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yash.ytms.dto.ServerResponse;
import com.yash.ytms.exception.UserNotFound;
import com.yash.ytms.model.Role;
import com.yash.ytms.model.User;
import com.yash.ytms.service.UserService;
import com.yash.ytms.serviceImpl.UserServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/useraccess")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	/*
	 * @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
	 */

	@PostMapping("/add-user")
	public ResponseEntity<User> saveEmpoyee(@RequestBody User user) throws Exception {

		/*
		 * so set default role
		 * 
		 * @author shubham bhake
		 */
		 Role role = new Role();
		 
		 if (user.getRole()== null) {
		 
		 role.setRoleId(4L); 
		 
		 
		 user.setRole(role);
	
		//.setPasswod(this.bCryptPasswordEncoder.encode(user.getPassword()));
		 
		 }
		User addUser = userService.addUser(user);
		 
		return new ResponseEntity<>(addUser, HttpStatus.CREATED);
	}

	@GetMapping("/get-all-user-details")
	public ResponseEntity<List<User>> getAll() {
		List<User> user = userService.getListOfAllUsers();
		return ResponseEntity.ok(user);
	}

	@PostMapping("/login")
	public ResponseEntity<ServerResponse> loginUser(@RequestBody User user) throws UserNotFound {
		ServerResponse res = userService.generateToken(user.getEmail(), user.getPassword());
		return new ResponseEntity<ServerResponse>(res, HttpStatus.OK);
	}

	/**
	 * this will clear the current user session and remove the token.
	 * 
	 * @param request  hold the request coming from the client.
	 * @param response return the response to client.
	 */
	@GetMapping(value = "/logout")
	public void logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("inside logoutpage");
		if (auth != null) {
			System.out.println("Logout...");
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

	}

	@GetMapping("/getById/{userId}")
	public ResponseEntity<User> getSingleUserById(@PathVariable Long userId) {
		return new ResponseEntity<User>(userService.getById(userId), HttpStatus.OK);
	}

	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<User> updateUserById(@PathVariable Long userId, @RequestBody User user) {

		User user1 = userServiceImpl.updateUserById(userId, user);
		
		System.out.println("role details in user-----"+user);

		return new ResponseEntity<>(user1, HttpStatus.OK);

	}
}

