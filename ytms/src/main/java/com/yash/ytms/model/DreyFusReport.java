package com.yash.ytms.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DreyFusReport {

	@Id
	private int dreyfusReport;
	private int empId;
	private String traineeName;
	private String inetrimAssesment;
	private String finalCapstoneProject;
	private String smeFeedback;
	private String commonSkills;
	private String atitute;
	private int overallScore;
	private String dreyfusCompetancy;
	private String remark;

}
