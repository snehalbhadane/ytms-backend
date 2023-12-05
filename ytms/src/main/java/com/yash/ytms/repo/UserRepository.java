package com.yash.ytms.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.yash.ytms.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public Optional<User> findByEmailAndPassword(String email,String password);
	public Optional<User> findByEmail(String email);

}