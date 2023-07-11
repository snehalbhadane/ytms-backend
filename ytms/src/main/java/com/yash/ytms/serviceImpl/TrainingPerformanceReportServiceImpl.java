package com.yash.ytms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ytms.model.TrainingPerformanceReport;
import com.yash.ytms.repo.TrainingPerformanceReportRepository;
import com.yash.ytms.service.TrainingPerformanceReportService;

@Service
public class TrainingPerformanceReportServiceImpl implements TrainingPerformanceReportService
{

	@Autowired
	TrainingPerformanceReportRepository trainingPerformanceRepo;

	@Override
	public TrainingPerformanceReport addReport(TrainingPerformanceReport tpr) {
		return this.trainingPerformanceRepo.save(tpr);
	}

	@Override
	public List<TrainingPerformanceReport> viewAllReports() {
		return this.trainingPerformanceRepo.findAll();
	}
}
