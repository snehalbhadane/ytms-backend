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

import com.yash.ytms.model.DreyFusReport;
import com.yash.ytms.service.DreyFusReportService;
@CrossOrigin
@RestController
@RequestMapping("/dreyFusReport")
public class DreyFusReportController {

	@Autowired
	DreyFusReportService dreyFusService;

	// add
	@PostMapping("/addReport")
	public ResponseEntity<DreyFusReport> addReport(@RequestBody DreyFusReport dfr) {
		return new ResponseEntity<DreyFusReport>(this.dreyFusService.addReport(dfr), HttpStatus.OK);

	}

	// view
	@GetMapping("/allReport")
	public ResponseEntity<List<DreyFusReport>> getAllDreyfusReport() {
		return new ResponseEntity<List<DreyFusReport>>(this.dreyFusService.viewDreyfusReport(), HttpStatus.OK);

	}

}
