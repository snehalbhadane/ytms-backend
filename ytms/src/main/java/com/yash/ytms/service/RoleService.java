package com.yash.ytms.service;

import java.util.List;

import com.yash.ytms.model.Role;


public interface RoleService {
	
	public Role addRole(Role role);
	public List<Role> getListOfAllRole();
}
