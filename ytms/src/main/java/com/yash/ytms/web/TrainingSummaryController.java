package com.yash.ytms.web;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ytms.config.LoggerConfiguration;
import com.yash.ytms.model.TrainingSummary;
import com.yash.ytms.service.TrainingSummaryService;

@RestController
@RequestMapping("/tsm")
public class TrainingSummaryController {
	
	private Logger logger = LoggerConfiguration.getLogger(TrainingSummaryController.class);
	
	@Autowired
	private TrainingSummaryService trainingSummaryService;
	
	@GetMapping("/get-trainig-summary-details")
	public ResponseEntity<List<TrainingSummary>> getAllSummary(){

		String methodName = "getAllSummary()";
		logger.info(methodName + " called from TrainingSummaryController.");
		
		List<TrainingSummary> trainingSummary = trainingSummaryService.getTrainingSummary();
		return ResponseEntity.ok(trainingSummary);
		
	}
	
	@PostMapping("/add-summary")
	public ResponseEntity<TrainingSummary> addTrainingSummary(@RequestBody TrainingSummary summary){
		
		TrainingSummary addTrainingSummary = trainingSummaryService.addTrainingSummary(summary);
		return new ResponseEntity<TrainingSummary>(addTrainingSummary,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/get-by-tsm-id/{training_summary_id}")
	public ResponseEntity<TrainingSummary> getByTsmId(@PathVariable Long training_summary_id ){
		
		
		return new ResponseEntity<TrainingSummary>(trainingSummaryService.getById(training_summary_id), HttpStatus.FOUND);
		
		
	}

}
















