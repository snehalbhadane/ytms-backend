package com.yash.ytms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ytms.model.TrainingPlan;

import com.yash.ytms.serviceImpl.TrainingPlanServiceImpl;

@RestController
@RequestMapping("/trainingPlan")
public class TrainingPlanController {
	
	@Autowired
	private TrainingPlanServiceImpl planServiceImpl;
	
	@PostMapping("/")
	public TrainingPlan saveTrainingPlan(@RequestBody TrainingPlan plan) {
		
		return planServiceImpl.saveTrainingPlanDetails(plan);
	}
	

}
