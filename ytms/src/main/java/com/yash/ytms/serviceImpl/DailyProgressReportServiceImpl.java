package com.yash.ytms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ytms.exception.DailyProgressReportNotFound;
import com.yash.ytms.model.DailyProgressReport;
import com.yash.ytms.repo.DailyProgressReportRepository;
import com.yash.ytms.service.DailyProgressReportService;

@Service
public class DailyProgressReportServiceImpl implements DailyProgressReportService {

	@Autowired
	DailyProgressReportRepository progressReportRepo;

	@Override
	public DailyProgressReport saveReport(DailyProgressReport report) {
		return progressReportRepo.save(report);
	}

	@Override
	public List<DailyProgressReport> getAllProgressReport() {
		return progressReportRepo.findAll();
	}

	@Override
	public void deleteReportById(int dailyReportId) {

		progressReportRepo.deleteById(dailyReportId);
	}

	@Override
	public void deleteAllDailyReports() {
		this.progressReportRepo.deleteAll();

	}

	private long preassessmentTest;
	private long topic1;
	private long topic2;
	private long topic3;
	private long topic4;
	private long avergaeScore;

	@Override
	public DailyProgressReport updateReport(int id, DailyProgressReport dpr) {
		// need to handle exception here
		DailyProgressReport dailyProgressReport = this.progressReportRepo.findById(id).orElseThrow();
		dailyProgressReport.setPreassessmentTest(dpr.getPreassessmentTest());
		dailyProgressReport.setTopic1(dpr.getTopic1());
		dailyProgressReport.setTopic2(dpr.getTopic2());
		dailyProgressReport.setTopic3(dpr.getTopic3());
		dailyProgressReport.setTopic4(dpr.getTopic4());
		dailyProgressReport.setAvergaeScore(dpr.getAvergaeScore());
		return dailyProgressReport;
	}

}
