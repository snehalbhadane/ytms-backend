package com.yash.ytms.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yash.ytms.exception.TrainingSummaryNotFound;
import com.yash.ytms.model.TrainingSummary;
import com.yash.ytms.model.User;
import com.yash.ytms.repo.TrainingSummaryRepository;
import com.yash.ytms.service.TrainingSummaryService;

@Service
public class TrainingSummaryServiceImpl implements TrainingSummaryService {

	@Autowired
	private TrainingSummaryRepository trainingSummaryRepository;

	@Override
	public TrainingSummary addTrainingSummary(TrainingSummary trainingSummary) {

		trainingSummary.setCreatedOn(LocalDate.now());
		return trainingSummaryRepository.save(trainingSummary);
	}

	@Override
	public List<TrainingSummary> getTrainingSummary() {
		return trainingSummaryRepository.findAll();
	}

	@Override
	public TrainingSummary getById(Long trainingSummaryId) {

		return trainingSummaryRepository.findById(trainingSummaryId)
				.orElseThrow(() -> new TrainingSummaryNotFound("This service is not found "));
	}

	@Override
	public void deleteTrainingSummary(Long trainingSummaryId) {
		trainingSummaryRepository.findById(trainingSummaryId)
				.orElseThrow(() -> new TrainingSummaryNotFound("Training Summary for This ID is Not Found"));
		trainingSummaryRepository.deleteById(trainingSummaryId);

	}

	@Override
	public TrainingSummary updateTrainingSummary(Long trainingSummaryId, TrainingSummary trainingSummary) {
		TrainingSummary trainingSummObj = trainingSummaryRepository.findById(trainingSummaryId)
				.orElseThrow(() -> new TrainingSummaryNotFound("Training Summary For This Id is Not Found"));

		trainingSummObj.setCreatedOn(trainingSummObj.getCreatedOn());
		trainingSummObj.setDuration(trainingSummary.getDuration());
		trainingSummObj.setTrainingPattern(trainingSummary.getTrainingPattern());
		trainingSummaryRepository.save(trainingSummObj);
		return trainingSummObj;
	}

}
