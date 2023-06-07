package com.yash.ytms.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yash.ytms.model.User;
import com.yash.ytms.repo.UserRepository;

/**
 * will fetch the user info from database to authenticate the user.
 * @author dheerendra.kag
 *
 */
@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> user = repository.findByEmail(username);
		System.out.println(user.get().toString());
		user.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		return user.map(MyUserDetails::new).get();
	}

}
