package com.yash.ytms.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ytms.dto.ServerResponse;
import com.yash.ytms.exception.UserAlreadyExistsException;
import com.yash.ytms.exception.UserNotFound;
import com.yash.ytms.model.User;
import com.yash.ytms.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/useraccess")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/add-user")
	public ResponseEntity<User> saveEmpoyee(  @RequestBody User user) throws UserAlreadyExistsException{
		User addUser = userService.addUser(user);
		return new ResponseEntity<>(addUser,HttpStatus.CREATED);
	}

	@GetMapping("/get-all-user-details")
	public ResponseEntity<List<User>> getAll() {
		List<User> user = userService.getListOfAllUsers();
		return  ResponseEntity.ok(user);
	}

	@PostMapping("/login")
	public ResponseEntity<ServerResponse> loginUser(@RequestBody User user) throws UserNotFound{
		ServerResponse res = userService.generateToken(user.getEmail(),  user.getPassword());
		return new ResponseEntity<ServerResponse>(res,HttpStatus.OK);
	}
	
	/**
	 * this will clear the current user session and remove the token.
	 * @param request hold the request coming from the client.
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

}
