package com.yash.ytms.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Associate {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "emp_id")
	private Long empId;
	
	@Column(name = "emp_name")
	private String empName;
	
	@Column(name = "exprience")
	private float exprience;
	
	@Column(name = "grade")
	private String grade;
	
	@Column(name = "current_skill")
	private String currentSkill;
	
	@Column(name = "current_allocation")
	private String currentAllocation;
	
	@Column(name = "project")
	private String project;
	
	@Column(name = "upgraded_skill_set")
	private String upgradedSkillSet;
	
	@JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "asst_trf_id", referencedColumnName = "trfId")
    private TrainingRequestForm trf;

	public Associate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Associate(Long id, Long empId, String empName, float exprience, String grade, String currentSkill,
			String currentAllocation, String project, String upgradedSkillSet, TrainingRequestForm trf) {
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
		this.trf = trf;
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

	public TrainingRequestForm getTrf() {
		return trf;
	}

	public void setTrf(TrainingRequestForm trf) {
		this.trf = trf;
	}

	@Override
	public String toString() {
		return "Associate [id=" + id + ", empId=" + empId + ", empName=" + empName + ", exprience=" + exprience
				+ ", grade=" + grade + ", currentSkill=" + currentSkill + ", currentAllocation=" + currentAllocation
				+ ", project=" + project + ", upgradedSkillSet=" + upgradedSkillSet + ", trf=" + trf + "]";
	}
}
