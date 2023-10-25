package com.yash.ytms;

// @author shubham bhake & akshay shinde

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.yash.ytms.exception.UserAlreadyExistsException;
import com.yash.ytms.model.Role;
import com.yash.ytms.model.User;
import com.yash.ytms.service.UserService;

@SpringBootApplication
@EnableAspectJAutoProxy
public class YtmsApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	UserService userService;

//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {

		SpringApplication.run(YtmsApplication.class, args);
		System.out.println("Wellcome to YTMS");
	}

	/*
	 * method is used generate admin
	 * 
	 * @author shubham bhake & akshay shinde
	 */
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		User adminUser = new User();

		System.out.println("YTMSs starting code");

		adminUser.setUserId(1L);
		adminUser.setEmpCode("1010101");
		adminUser.setFirstName("Shubham");
		adminUser.setLastName("Bhake");
		adminUser.setEmail("Shubham.bhake@yash.com");
		//adminUser.setPasswod(this.bCryptPasswordEncoder.encode("Shubham@17"));
		adminUser.setPasswod("Shubham@17");
		adminUser.setMobile("1234567891");
		adminUser.setGender("Male");
		adminUser.setDobDate(null);
		adminUser.setExperience("5 years");

		Role role1 = new Role();
		role1.setRoleId(3L);

		adminUser.setRole(role1);

		adminUser.setLocation(null);
		adminUser.setProject(null);
		adminUser.setDesignation("Manager");

		User user1 = this.userService.addUser(adminUser);
		System.out.println(user1.toString());

	}

}
