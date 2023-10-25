package com.yash.ytms.web;

import java.util.List;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ytms.config.LoggerConfiguration;
import com.yash.ytms.model.TrainingSummary;
import com.yash.ytms.service.TrainingSummaryService;
@CrossOrigin
@RestController
@RequestMapping("/tsm")
public class TrainingSummaryController {

	private Logger logger = LoggerConfiguration.getLogger(TrainingSummaryController.class);

	@Autowired
	private TrainingSummaryService trainingSummaryService;

	// Get Training Summary Details
	@GetMapping("/getTrainigSummaryDetails")
	public ResponseEntity<List<TrainingSummary>> getAllSummary() {

		String methodName = "getAllSummary()";
		logger.info(methodName + " called from TrainingSummaryController.");

		List<TrainingSummary> trainingSummary = trainingSummaryService.getTrainingSummary();
		return ResponseEntity.ok(trainingSummary);

	}

	// Add Training Summary Details
	@PostMapping("/addSummary")
	public ResponseEntity<TrainingSummary> addTrainingSummary(@RequestBody TrainingSummary summary) {

		String methodName = "addTrainingSummary()";
		logger.info(methodName + " called from TrainingSummaryController.");
		TrainingSummary addTrainingSummary = trainingSummaryService.addTrainingSummary(summary);
		return new ResponseEntity<TrainingSummary>(addTrainingSummary, HttpStatus.CREATED);

	}

	// Get Single Summary Details
	@GetMapping("/getByTsmId/{trainingSummaryId}")
	public ResponseEntity<TrainingSummary> getByTsmId(@PathVariable Long trainingSummaryId) {

		String methodName = "getByTsmId()";
		logger.info(methodName + " called from TrainingSummaryController.");
		return new ResponseEntity<TrainingSummary>(trainingSummaryService.getById(trainingSummaryId), HttpStatus.FOUND);

	}

	// Delete Summary Details
	@DeleteMapping("/deleteTrSummary/{trainingSummaryId}")
	public void deleteTrainningSum(@PathVariable Long trainingSummaryId) {

		String methodName = "deleteTrainningSum()";
		logger.info(methodName + " called from TrainingSummaryController.");
		trainingSummaryService.deleteTrainingSummary(trainingSummaryId);
	}

	// Update Training Summary Details
	@PutMapping("/updateTrainingSummary/{trainingSummaryId}")
	public ResponseEntity<TrainingSummary> updateTrSummary(@PathVariable Long trainingSummaryId,
			@RequestBody TrainingSummary trainingSummary) {

		String methodName = "updateTrSummary()";
		logger.info(methodName + " called from TrainingSummaryController.");

		TrainingSummary updateTSM = trainingSummaryService.updateTrainingSummary(trainingSummaryId, trainingSummary);
		return ResponseEntity.ok(updateTSM);

	}

	// Get Training Summary By Trainer Name
	@GetMapping("/getSummaryByName/{trainerName}")
	public ResponseEntity<List<TrainingSummary>> getSummaryByName(@PathVariable String trainerName) {

		return new ResponseEntity<List<TrainingSummary>>(this.trainingSummaryService.getSummaryByName(trainerName),
				HttpStatus.OK);
	}

}