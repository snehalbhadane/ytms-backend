package com.yash.ytms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ytms.model.TrainingPerformanceReport;
import com.yash.ytms.service.TrainingPerformanceReportService;
@CrossOrigin
@RestController
@RequestMapping("/trainingPerfRepo")
public class TrainingPerformanceReportController {

	@Autowired
	TrainingPerformanceReportService tprService;

	// add
	@PostMapping("/addReport")
	public ResponseEntity<TrainingPerformanceReport> addReport(@RequestBody TrainingPerformanceReport tpr) {
		return new ResponseEntity<TrainingPerformanceReport>(this.tprService.addReport(tpr), HttpStatus.OK);
	}

	// view
	@GetMapping("/getAllReport")
	public ResponseEntity<List<TrainingPerformanceReport>> getAllReport() {
		return new ResponseEntity<List<TrainingPerformanceReport>>(this.tprService.viewAllReports(), HttpStatus.OK);

	}
}
