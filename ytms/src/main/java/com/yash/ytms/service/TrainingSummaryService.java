package com.yash.ytms.service;

import java.util.List;
import com.yash.ytms.model.TrainingSummary;

public interface TrainingSummaryService {

	public TrainingSummary addTrainingSummary(TrainingSummary trainingSummary);

	public List<TrainingSummary> getTrainingSummary();

	public TrainingSummary getById(Long trainingSummaryId);

	public TrainingSummary updateTrainingSummary(Long trainingSummaryId, TrainingSummary trainingSummary);

	public void deleteTrainingSummary(Long trainingSummaryId);

}
