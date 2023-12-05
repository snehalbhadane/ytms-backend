package com.yash.ytms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yash.ytms.model.TrainingPerformanceReport;

@Service
public interface TrainingPerformanceReportService {

	TrainingPerformanceReport addReport(TrainingPerformanceReport tpr);
	
	List<TrainingPerformanceReport> viewAllReports();

}
