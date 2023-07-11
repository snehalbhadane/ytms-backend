package com.yash.ytms.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="training_paln")
public class TrainingPlan {
	
	
	@Id
	@Column(name = "trainer_plan_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long trainingPlanId;

	
	@Column(name = "training_name")
	private String trainingName;

	@Column(name = "topic")
	private String topic;

	@Column(name = "contents_coverage")
	private String contentsCoverage;

	@Column(name = "extra_topic_coverage")
	private String extraTopicCoverage;

	@Column(name = "duration")
	private int duration;

	@Column(name = "planned_start_date")
	private LocalDateTime plannedStartDate;

	@Column(name = "planned_end_date")
	private LocalDateTime plannedEndDate;
	
	@Column(name = "actual_start_date")
	private LocalDateTime actualStartDate;
	
	@Column(name = "actual_end_date")
	private LocalDateTime actualEndDate;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "remark")
	private String remark;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "trainer_id", referencedColumnName = "trainer_id")
	private Trainer trainer;

	public TrainingPlan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrainingPlan(long trainingPlanId, String trainingName, String topic, String contentsCoverage,
			String extraTopicCoverage, int duration, LocalDateTime plannedStartDate, LocalDateTime plannedEndDate,
			LocalDateTime actualStartDate, LocalDateTime actualEndDate, String status, String remark, User user,
			Trainer trainer) {
		super();
		this.trainingPlanId = trainingPlanId;
		this.trainingName = trainingName;
		this.topic = topic;
		this.contentsCoverage = contentsCoverage;
		this.extraTopicCoverage = extraTopicCoverage;
		this.duration = duration;
		this.plannedStartDate = plannedStartDate;
		this.plannedEndDate = plannedEndDate;
		this.actualStartDate = actualStartDate;
		this.actualEndDate = actualEndDate;
		this.status = status;
		this.remark = remark;
		this.user = user;
		this.trainer = trainer;
	}

	public long getTrainingPlanId() {
		return trainingPlanId;
	}

	public void setTrainingPlanId(long trainingPlanId) {
		this.trainingPlanId = trainingPlanId;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getContentsCoverage() {
		return contentsCoverage;
	}

	public void setContentsCoverage(String contentsCoverage) {
		this.contentsCoverage = contentsCoverage;
	}

	public String getExtraTopicCoverage() {
		return extraTopicCoverage;
	}

	public void setExtraTopicCoverage(String extraTopicCoverage) {
		this.extraTopicCoverage = extraTopicCoverage;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public LocalDateTime getPlannedStartDate() {
		return plannedStartDate;
	}

	public void setPlannedStartDate(LocalDateTime plannedStartDate) {
		this.plannedStartDate = plannedStartDate;
	}

	public LocalDateTime getPlannedEndDate() {
		return plannedEndDate;
	}

	public void setPlannedEndDate(LocalDateTime plannedEndDate) {
		this.plannedEndDate = plannedEndDate;
	}

	public LocalDateTime getActualStartDate() {
		return actualStartDate;
	}

	public void setActualStartDate(LocalDateTime actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public LocalDateTime getActualEndDate() {
		return actualEndDate;
	}

	public void setActualEndDate(LocalDateTime actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}


	
}
