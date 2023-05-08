package com.yash.ytms.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trainer_task")
public class TrainerTask {

	@Id
	@Column(name = "trainer_task_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long trainerTaskId;

	@Column(name = "task_date")
	private LocalDateTime taskDate;

	@Column(name = "first_half")
	private String firstHalf;

	@Column(name = "first_half_description")
	private String firstHalfDescription;

	@Column(name = "second_half")
	private String secondHalf;

	@Column(name = "second_half_description")
	private String secondHalfDescription;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by_id", referencedColumnName = "user_id")
	private User createdBy;

	@Column(name = "created_on")
	private LocalDateTime createdOn;

	@Column(name = "updated_on")
	private LocalDateTime updatedOn;

	@Column(name = "is_active")
	private boolean active;

	public TrainerTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrainerTask(Long trainerTaskId, LocalDateTime taskDate, String firstHalf, String firstHalfDescription,
			String secondHalf, String secondHalfDescription, User createdBy, LocalDateTime createdOn,
			LocalDateTime updatedOn, boolean active) {
		super();
		this.trainerTaskId = trainerTaskId;
		this.taskDate = taskDate;
		this.firstHalf = firstHalf;
		this.firstHalfDescription = firstHalfDescription;
		this.secondHalf = secondHalf;
		this.secondHalfDescription = secondHalfDescription;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.active = active;
	}

	public Long getTrainerTaskId() {
		return trainerTaskId;
	}

	public void setTrainerTaskId(Long trainerTaskId) {
		this.trainerTaskId = trainerTaskId;
	}

	public LocalDateTime getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(LocalDateTime taskDate) {
		this.taskDate = taskDate;
	}

	public String getFirstHalf() {
		return firstHalf;
	}

	public void setFirstHalf(String firstHalf) {
		this.firstHalf = firstHalf;
	}

	public String getFirstHalfDescription() {
		return firstHalfDescription;
	}

	public void setFirstHalfDescription(String firstHalfDescription) {
		this.firstHalfDescription = firstHalfDescription;
	}

	public String getSecondHalf() {
		return secondHalf;
	}

	public void setSecondHalf(String secondHalf) {
		this.secondHalf = secondHalf;
	}

	public String getSecondHalfDescription() {
		return secondHalfDescription;
	}

	public void setSecondHalfDescription(String secondHalfDescription) {
		this.secondHalfDescription = secondHalfDescription;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
