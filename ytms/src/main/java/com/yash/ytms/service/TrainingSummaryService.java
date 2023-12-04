package com.yash.ytms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.yash.ytms.model.TrainingSummary;

public interface TrainingSummaryService {

	public TrainingSummary addTrainingSummary(TrainingSummary trainingSummary);

	public List<TrainingSummary> getTrainingSummary();

	public TrainingSummary getById(Long trainingSummaryId);

	public TrainingSummary updateTrainingSummary(Long trainingSummaryId, TrainingSummary trainingSummary);

	public void deleteTrainingSummary(Long trainingSummaryId);

	public List<TrainingSummary> getSummaryByCreatedDateOrName(LocalDate createdOn,String trainingName);

}
