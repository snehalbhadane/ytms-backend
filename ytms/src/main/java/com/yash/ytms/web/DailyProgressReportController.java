package com.yash.ytms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ytms.model.DailyProgressReport;
import com.yash.ytms.service.DailyProgressReportService;

@RestController
@RequestMapping("/dailyProgressReport")
public class DailyProgressReportController {

	@Autowired
	DailyProgressReportService dailyProgressReport;

	// create daily progress report
	@PostMapping("/saveDailyProgressReport")
	public ResponseEntity<DailyProgressReport> saveDailyProgressReport(@RequestBody DailyProgressReport report) {
		return new ResponseEntity<DailyProgressReport>(dailyProgressReport.saveReport(report), HttpStatus.OK);

	}

	// list all report
	@GetMapping("/getAllDailyReport")
	public List<DailyProgressReport> getAllDailyProgressReport() {
		return this.dailyProgressReport.getAllProgressReport();
	}

	// update all daily progress report
	@PutMapping("/updateDailyReport/{id}")
	public ResponseEntity<DailyProgressReport> updateDailyProgressReport(@PathVariable("id")int id,
			@RequestBody DailyProgressReport dpr){
		return new ResponseEntity<DailyProgressReport>(dailyProgressReport.updateReport(id , dpr) , HttpStatus.OK);
	}

	// delete one progress report
	@DeleteMapping("/deleteReport/{id}")
	public ResponseEntity<DailyProgressReport> deleteDailyProgressReport(@PathVariable("id") int id) {
		this.dailyProgressReport.deleteReportById(id);
		return new ResponseEntity<DailyProgressReport>(HttpStatus.OK);
	}

	// delete all progree report
	@DeleteMapping("/deleteAllReport")
	public ResponseEntity<DailyProgressReport> deleteAllDailyProgressReport() {
		this.dailyProgressReport.deleteAllDailyReports();
		return new ResponseEntity<DailyProgressReport>(HttpStatus.OK);
	}

}
