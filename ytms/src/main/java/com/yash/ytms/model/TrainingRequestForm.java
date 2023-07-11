package com.yash.ytms.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * This class will responsible to map the data with training_request_form table
 * @author dheerendra.kag
 * @version 1.0
 * @since 04/05/2023
 */
@Entity
@Table(name="training_request_form")
public class TrainingRequestForm implements Serializable{

	private static final long serialVersionUID = 1234567L;
	
	/**
	 * This will hold the auto generated primary keys value
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long trfId;
	
	/**
	 * This will hold the training title name
	 */
	@NotEmpty(message = "The training title is required.")
	@Column(name = "training_title")
	private String trainingTitle;
	
	/**
	 * This will hold the type of training like online or offline
	 */
	@NotEmpty(message = "The training type is required.")
	@Column(name = "training_type")
	private String trainingType;
	
	@NotEmpty(message = "The resource type is required.")
	@Column(name = "resource_type")
	private String resourceType;
	
	/**
	 * This will hold the duration of training
	 */
	@Column(name = "duration")
	private int duration;
	
	/**
	 * indicate the purpose of training
	 */
	@Column(name = "purpose_of_training")
	private String purposeOfTraining;
	
	/**
	 * This will hold the initiate date of training
	 */
	@NotNull(message = "The initiated date is required.")
	@Column(name = "initiated_from")
	private String initiatedFrom;
	
	/**
	 * This will hold the project name
	 */
	@Column(name = "project_Name")
	private String projectName;
	
	/**
	 * This will hold the skill to be impartent 
	 */
	@Column(name = "skill_to_be_impartent")
	private String skillToBeImpartent;
	
	/**
	 * This will hold the number of participants in the training
	 */
	@Column(name = "no_of_participants")
	private int noOfParticipants;
	
	/**
	 * This will hold the start date of training
	 */
	@NotNull(message = "The start date is required.")
	@Column(name = "start_date")
	private LocalDate startDate;
	
	/**
	 * This will hold the end date of training
	 */
	@NotNull(message = "The end date is required.")
	@Column(name = "end_date")
	private LocalDate endDate;
	
	/**
	 * This will hold the request form status is approved or not
	 */
	@Column(name = "status")
	private String status;
	
	@Column(name="created_by")
	private String createdBy;
	
	/**
	 * Hold the list of associate which will participate in the training
	 */
	
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "asst_trf_id", referencedColumnName = "trfId")
    private List<Associate> associates;

	public TrainingRequestForm() {
		super();
	}

	public TrainingRequestForm(Long trfId, String trainingTitle, String trainingType, String resourceType, int duration,
			String purposeOfTraining, String initiatedFrom, String projectName, String skillToBeImpartent,
			int noOfParticipants, LocalDate startDate, LocalDate endDate, List<Associate> associates) {
		super();
		this.trfId = trfId;
		this.trainingTitle = trainingTitle;
		this.trainingType = trainingType;
		this.resourceType = resourceType;
		this.duration = duration;
		this.purposeOfTraining = purposeOfTraining;
		this.initiatedFrom = initiatedFrom;
		this.projectName = projectName;
		this.skillToBeImpartent = skillToBeImpartent;
		this.noOfParticipants = noOfParticipants;
		this.startDate = startDate;
		this.endDate = endDate;
		this.associates = associates;
	}

	public Long getTrfId() {
		return trfId;
	}

	public void setTrfId(Long trfId) {
		this.trfId = trfId;
	}

	public String getTrainingTitle() {
		return trainingTitle;
	}

	public void setTrainingTitle(String trainingTitle) {
		this.trainingTitle = trainingTitle;
	}

	public String getTrainingType() {
		return trainingType;
	}

	public void setTrainingType(String trainingType) {
		this.trainingType = trainingType;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getPurposeOfTraining() {
		return purposeOfTraining;
	}

	public void setPurposeOfTraining(String purposeOfTraining) {
		this.purposeOfTraining = purposeOfTraining;
	}

	public String getInitiatedFrom() {
		return initiatedFrom;
	}

	public void setInitiatedFrom(String initiatedFrom) {
		this.initiatedFrom = initiatedFrom;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getSkillToBeImpartent() {
		return skillToBeImpartent;
	}

	public void setSkillToBeImpartent(String skillToBeImpartent) {
		this.skillToBeImpartent = skillToBeImpartent;
	}

	public int getNoOfParticipants() {
		return noOfParticipants;
	}

	public void setNoOfParticipants(int noOfParticipants) {
		this.noOfParticipants = noOfParticipants;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public List<Associate> getAssociates() {
		return associates;
	}

	public void setAssociates(List<Associate> associates) {
		this.associates = associates;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "TrainingRequestForm [trfId=" + trfId + ", trainingTitle=" + trainingTitle + ", trainingType="
				+ trainingType + ", resourceType=" + resourceType + ", duration=" + duration + ", purposeOfTraining="
				+ purposeOfTraining + ", initiatedFrom=" + initiatedFrom + ", projectName=" + projectName
				+ ", skillToBeImpartent=" + skillToBeImpartent + ", noOfParticipants=" + noOfParticipants
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status + ", createdBy="
				+ createdBy + ", associates=" + associates + "]";
	}

}
