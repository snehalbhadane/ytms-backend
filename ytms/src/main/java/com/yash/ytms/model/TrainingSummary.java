package com.yash.ytms.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="training_summary")
public class TrainingSummary {
	
	@Id
	@Column(name = "training_summary_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trainingSummaryId;
	
	@NotNull(message="Fill Training pattern")
	@Column(name = "training_pattern")
	private String trainingPattern;
	
	
	@Column(name = "duration")
	private int duration;
	
	@Column(name = "created_on")
	private LocalDate createdOn;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "training_plan")
	private TrainingPlan trainingPlan;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User trainer;
	
	public TrainingSummary() {
		super();
		
	}

	public TrainingSummary(Long training_summary_id, TrainingPlan trainingPlan, User trainer,
			String trainingPattern, int duration, LocalDate createdOn) {
		super();
		this.trainingSummaryId = training_summary_id;
		this.trainingPlan = trainingPlan;
		this.trainer = trainer;
		this.trainingPattern = trainingPattern;
		this.duration = duration;
		this.createdOn = createdOn;
	}

	public Long getTrainingSummaryId() {
		return trainingSummaryId;
	}

	public void setTrainingSummaryId(Long trainingSummaryId) {
		this.trainingSummaryId = trainingSummaryId;
	}

	public TrainingPlan getTrainingPlan() {
		return trainingPlan;
	}

	public void setTrainingPlan(TrainingPlan trainingPlan) {
		this.trainingPlan = trainingPlan;
	}

	public User getTrainer() {
		return trainer;
	}

	public void setTrainer(User trainer) {
		this.trainer = trainer;
	}

	public String getTrainingPattern() {
		return trainingPattern;
	}

	public void setTrainingPattern(String trainingPattern) {
		this.trainingPattern = trainingPattern;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

}
