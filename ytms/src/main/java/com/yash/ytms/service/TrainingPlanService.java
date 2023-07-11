package com.yash.ytms.service;

import java.util.List;

import com.yash.ytms.model.TrainingPlan;


public interface TrainingPlanService {
	
	
	public TrainingPlan saveTrainingPlanDetails(TrainingPlan plan);
	
	public List<TrainingPlan> getListOfTrainingPlan();
	
	public void deleteTrainingPlanbyId(long id );
	
	public TrainingPlan updateTrainingPlan(TrainingPlan plan , long id);

}
