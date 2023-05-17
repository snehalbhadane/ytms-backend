package com.yash.ytms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.yash.ytms.model.TrainingPlan;
import com.yash.ytms.repo.TrainingPlanRepository;

import com.yash.ytms.service.TrainingPlanService;

@Service
public class TrainingPlanServiceImpl implements TrainingPlanService{
	
	@Autowired
	private TrainingPlanRepository planRepository;

	
	@Override
	public TrainingPlan saveTrainingPlanDetails(TrainingPlan plan) {
		
		return planRepository.save(plan);
	}

}
