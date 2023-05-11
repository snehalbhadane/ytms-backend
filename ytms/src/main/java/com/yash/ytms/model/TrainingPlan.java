package com.yash.ytms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "training_plan")
public class TrainingPlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String plan;
	

	public TrainingPlan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrainingPlan(long id, String plan) {
		super();
		this.id = id;
		this.plan = plan;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	
}
