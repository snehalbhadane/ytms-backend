package com.yash.ytms.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@Setter
@Getter
public class DailyProgressReport {

	@Id
	private int dailyReportId;
	private int empId;
	private String traineeName;
	private long preassessmentTest;
	private long topic1;
	private long topic2;
	private long topic3;
	private long topic4;
	private long avergaeScore;

}
