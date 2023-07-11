package com.yash.ytms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ytms.model.Role;
import com.yash.ytms.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/add-role")
	public ResponseEntity<Role> addNewRole(@RequestBody Role role){
		
		Role addRole = roleService.addRole(role);
		
		return new ResponseEntity<Role>(addRole, HttpStatus.CREATED);
	}
	
	@GetMapping("/get-all-rolles")
	public ResponseEntity<List<Role>> getAllRoles(){
		List<Role> listOfAllRole = roleService.getListOfAllRole();
		
		return  ResponseEntity.ok(listOfAllRole);
		
	}
	

}
