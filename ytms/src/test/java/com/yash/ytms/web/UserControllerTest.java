package com.yash.ytms.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yash.ytms.model.Role;
import com.yash.ytms.model.User;
import com.yash.ytms.serviceImpl.UserServiceImpl;

@WebMvcTest(UserController.class)
 class UserControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	UserServiceImpl userServiceImpl;
	
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
	void createUserTest() throws JsonProcessingException, Exception {
		
		when(userServiceImpl.addUser(user)).thenReturn(user);
		
		mockMvc.perform(post("/useraccess/add-user")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(user)))
				.andExpect(status().isCreated());
		
	}
	
	@Test
	void createAllUserTest() throws Exception {
		
		MvcResult mvcResult;
		
		List<User> userlist = Arrays.asList(user);
		
		when(userServiceImpl.getListOfAllUsers()).thenReturn(userlist);
		
		
		mvcResult=mockMvc.perform(MockMvcRequestBuilders.get("/useraccess/get-all-user-details"))
		.andDo(print()).andReturn();
		
		assertEquals(200, mvcResult.getResponse().getStatus());
		
	}
	
	
	

}
