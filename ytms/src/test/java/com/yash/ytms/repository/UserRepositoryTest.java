package com.yash.ytms.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.yash.ytms.model.Role;
import com.yash.ytms.model.User;
import com.yash.ytms.repo.UserRepository;

@SpringBootTest
 class UserRepositoryTest {
	
	@Mock
	private UserRepository userRepository;
	
	private User user;
	
	@BeforeEach
	public void init() throws ParseException {
		
		user=new User();
		
		String dob = "01/17/1995";

		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		
		user.setEmpCode("1016444");
		user.setFirstName("abc");
		user.setLastName("xyz");
		user.setEmail("abc.xyz@yash.com");
		user.setPasswod("abc@1234");
		user.setMobile("1234567890");
		user.setGender("M");
		user.setExperience("3.1");
		user.setLocation("pune");
		user.setProject("internal");
		user.setDesignation("software engineer");
		user.setDobDate(formatter.parse(dob));
		
		Role role=new Role();
		role.setRoleId(101L);
		role.setRoleName("admin");
		role.setRoleCode("ad");
		
	}
	
	@Test
	 void createUserTest() {

		userRepository.save(user);
		assertThatObject(user).isNotNull();
	}
	
	@Test
	void allUesrTest() {
		
		List<User> findAll = userRepository.findAll();
		
		assertThat(findAll).isEmpty();
		
	}
	
	

}
