package com.yash.ytms.service;

import java.util.List;

import com.yash.ytms.model.TrainingPlan;


public interface TrainingPlanService {
	
	
	public TrainingPlan saveTrainingPlanDetails(TrainingPlan plan);
	
	public List<TrainingPlan> getListOfTrainingPlan();
	
	public void deleteTrainingPlanbyId(long id );
	
	public TrainingPlan updateTrainingPlan(TrainingPlan plan , long id);
	
	/*
	 * @author shubham bhake 
	 * this method is for gettinf details of training plan base on trainingPlanId
	 * this will mostly use while updating plan from UI side
	 * as we need data prefilled before update on UI.
	 */
   
	public TrainingPlan getTrainingPlanId(long trainingPlanId);

}
