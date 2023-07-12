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
	
	public DailyProgressReport(int dailyReportId, int empId, String traineeName, long preassessmentTest, long topic1,
			long topic2, long topic3, long topic4, long avergaeScore) {
		super();
		this.dailyReportId = dailyReportId;
		this.empId = empId;
		this.traineeName = traineeName;
		this.preassessmentTest = preassessmentTest;
		this.topic1 = topic1;
		this.topic2 = topic2;
		this.topic3 = topic3;
		this.topic4 = topic4;
		this.avergaeScore = avergaeScore;
	}

	public int getDailyReportId() {
		return dailyReportId;
	}

	public void setDailyReportId(int dailyReportId) {
		this.dailyReportId = dailyReportId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public long getPreassessmentTest() {
		return preassessmentTest;
	}

	public void setPreassessmentTest(long preassessmentTest) {
		this.preassessmentTest = preassessmentTest;
	}

	public long getTopic1() {
		return topic1;
	}

	public void setTopic1(long topic1) {
		this.topic1 = topic1;
	}

	public long getTopic2() {
		return topic2;
	}

	public void setTopic2(long topic2) {
		this.topic2 = topic2;
	}

	public long getTopic3() {
		return topic3;
	}

	public void setTopic3(long topic3) {
		this.topic3 = topic3;
	}

	public long getTopic4() {
		return topic4;
	}

	public void setTopic4(long topic4) {
		this.topic4 = topic4;
	}

	public long getAvergaeScore() {
		return avergaeScore;
	}

	public void setAvergaeScore(long avergaeScore) {
		this.avergaeScore = avergaeScore;
	}
	
	

}
