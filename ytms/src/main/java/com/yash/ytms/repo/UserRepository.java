package com.yash.ytms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.ytms.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
//	public User findByEmailAndPasswod(String email,String passwod);

}
