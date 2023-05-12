package com.yash.ytms.service;

import java.util.List;

import com.yash.ytms.model.TrainingSummary;

public interface TrainingSummaryService {
	
	public TrainingSummary addTrainingSummary(TrainingSummary trainingSummary);
	
	public List<TrainingSummary> getTrainingSummary();
	
	public TrainingSummary getById(Long training_summary_id );

	
}
