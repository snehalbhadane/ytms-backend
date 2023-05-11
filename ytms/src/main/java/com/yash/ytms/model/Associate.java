package com.yash.ytms.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Associate implements Serializable{
	
	private static final long serialVersionUID = 1234568L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "emp_id")
	private Long empId;
	
	@NotEmpty(message = "The employee name is required.")
	@Column(name = "emp_name")
	private String empName;
	
	@Column(name = "exprience")
	private float exprience;
	
	@NotEmpty(message = "The grade is required.")
	@Column(name = "grade")
	private String grade;
	
	@NotEmpty(message = "The current skills is required.")
	@Column(name = "current_skill")
	private String currentSkill;
	
	@Column(name = "current_allocation")
	private String currentAllocation;
	
	@Column(name = "project")
	private String project;
	
	@Column(name = "upgraded_skill_set")
	private String upgradedSkillSet;

	public Associate() {
		super();
	}

	public Associate(Long id, Long empId, String empName, float exprience, String grade, String currentSkill,
			String currentAllocation, String project, String upgradedSkillSet) {
		super();
		this.id = id;
		this.empId = empId;
		this.empName = empName;
		this.exprience = exprience;
		this.grade = grade;
		this.currentSkill = currentSkill;
		this.currentAllocation = currentAllocation;
		this.project = project;
		this.upgradedSkillSet = upgradedSkillSet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public float getExprience() {
		return exprience;
	}

	public void setExprience(float exprience) {
		this.exprience = exprience;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCurrentSkill() {
		return currentSkill;
	}

	public void setCurrentSkill(String currentSkill) {
		this.currentSkill = currentSkill;
	}

	public String getCurrentAllocation() {
		return currentAllocation;
	}

	public void setCurrentAllocation(String currentAllocation) {
		this.currentAllocation = currentAllocation;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getUpgradedSkillSet() {
		return upgradedSkillSet;
	}

	public void setUpgradedSkillSet(String upgradedSkillSet) {
		this.upgradedSkillSet = upgradedSkillSet;
	}

	@Override
	public String toString() {
		return "Associate [id=" + id + ", empId=" + empId + ", empName=" + empName + ", exprience=" + exprience
				+ ", grade=" + grade + ", currentSkill=" + currentSkill + ", currentAllocation=" + currentAllocation
				+ ", project=" + project + ", upgradedSkillSet=" + upgradedSkillSet + "]";
	}
}
