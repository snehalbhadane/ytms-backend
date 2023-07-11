package com.yash.ytms.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainingPerformanceReport {
	@Id
	private int reportId;
	private int empId;
	private String traineeName;
	private String skillGroup;
	private int code;
	private String topic;
	private String functionalityCompleted;
	private int UiDesign;
	private int backend;
	private int communicationSkills;
	private int toalMarks;
}
