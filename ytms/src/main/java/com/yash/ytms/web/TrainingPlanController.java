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
import com.yash.ytms.model.TrainingPlan;
import com.yash.ytms.serviceImpl.TrainingPlanServiceImpl;
@CrossOrigin
@RestController
@RequestMapping("/trainingPlan")
public class TrainingPlanController {

	private Logger logger = LoggerConfiguration.getLogger(TrainerController.class);

	@Autowired
	private TrainingPlanServiceImpl planServiceImpl;

	@PostMapping("/saveTrainingplan")
	public TrainingPlan saveTrainingPlan(@RequestBody TrainingPlan plan) {
		logger.info("In Saving Training plan Controller");
		return planServiceImpl.saveTrainingPlanDetails(plan);
	}

	// list training plan
	@GetMapping("/allTrainingPlan")
	public List<TrainingPlan> getTrainingPlanlist() {
		logger.info("In controller to get training plan list");
		return this.planServiceImpl.getListOfTrainingPlan();
	}

	// update training plan
	@PutMapping("/updateTrainingPlan/{id}")
	public ResponseEntity<TrainingPlan> updateTrainingPlan(@PathVariable("id") long id,
			@RequestBody TrainingPlan trainingPlan) {
		logger.info("In Update training plan controller");
		
		//System.out.println("check plan ..........."+trainingPlan.toString());
		
		return new ResponseEntity<TrainingPlan>(planServiceImpl.updateTrainingPlan(trainingPlan, id), HttpStatus.OK);
	}

	// delete training plan
	@DeleteMapping("/deletePlan/{id}")
	public boolean deleteTrainingPlan(@PathVariable("id") long id) {
		logger.info("Delete Training Plan controller");
		this.planServiceImpl.deleteTrainingPlanbyId(id);
		return true;

	}
	
	@GetMapping("GetTrainingPlanById/{trainingPlanId}")
	public ResponseEntity<TrainingPlan> getTrainingPlanByid(@PathVariable long trainingPlanId) {
		
		return new ResponseEntity<TrainingPlan>(planServiceImpl.getTrainingPlanId(trainingPlanId),HttpStatus.OK);
		
	}
	
	

}
