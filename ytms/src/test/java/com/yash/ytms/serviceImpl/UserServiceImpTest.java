package com.yash.ytms.serviceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.yash.ytms.model.Role;
import com.yash.ytms.model.User;
import com.yash.ytms.repo.UserRepository;

@SpringBootTest
public class UserServiceImpTest {
	
	@InjectMocks 
	private UserServiceImpl userServiceImpl;
	
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

		when(userRepository.save(user)).thenReturn(user);
		User addUser = userServiceImpl.addUser(user);
		assertThat(addUser.getFirstName()).isSameAs(user.getFirstName());
		Mockito.verify(userRepository, Mockito.atLeastOnce()).save(user);
	}
	
	@Test
	void getAllUserTest() {
		
		List<User> userList = Arrays.asList(user);
		
		when(userRepository.findAll()).thenReturn(userList);
		
		List<User> allUsers = userServiceImpl.getListOfAllUsers();
		
		assertThat(allUsers).hasSize(1);
	}
	
	
	

}
