package com.yash.ytms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@Column(name = "role_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;

	@Column(name = "role_name")
	private String roleName;

	@Column(name = "role_code")
	private String roleCode;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(Long roleId, String roleName, String roleCode) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleCode = roleCode;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleCode=" + roleCode + "]";
	}

	
}