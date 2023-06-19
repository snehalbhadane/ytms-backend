package com.yash.ytms.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.yash.ytms.config.JwtUtil;
import com.yash.ytms.config.MyUserDetailService;
import com.yash.ytms.dto.ServerResponse;
import com.yash.ytms.exception.UserNotFound;
import com.yash.ytms.model.User;
import com.yash.ytms.repo.UserRepository;
import com.yash.ytms.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailService userDetailService;

	@Autowired
	private JwtUtil jwtutil;
	
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
	public ServerResponse generateToken(String email, String password) throws UserNotFound  {
		
		ServerResponse resp = new ServerResponse();
        try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		} catch (BadCredentialsException e) {
			resp.setStatus("400");
			resp.setMessage("Invalid User Credentials");
			return resp;
		}
		User checkUser = userRepository.findByEmailAndPassword(email, password).orElseThrow(()-> new UserNotFound("This user not  exist"));
		final UserDetails userDetails = userDetailService.loadUserByUsername(email);
		final String jwt = jwtutil.generateToken(userDetails);

        resp.setStatus("200");
		resp.setMessage("Login succesfull");
		resp.setAuthToken(jwt);
		resp.setUser(checkUser);
		return resp;
	}

	

}
