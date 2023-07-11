package com.yash.ytms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yash.ytms.model.DailyProgressReport;

@Service
public interface DailyProgressReportService {

	DailyProgressReport saveReport(DailyProgressReport report);

	List<DailyProgressReport> getAllProgressReport();
	
	void deleteReportById(int dailyReportId);

	void deleteAllDailyReports();

	DailyProgressReport updateReport(int id, DailyProgressReport dpr);

}
