package com.yash.ytms.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ytms.config.LoggerConfiguration;
import com.yash.ytms.exception.TrainingSummaryNotFound;
import com.yash.ytms.model.TrainingSummary;
import com.yash.ytms.model.User;
import com.yash.ytms.repo.TrainingSummaryRepository;
import com.yash.ytms.service.TrainingSummaryService;

@Service
public class TrainingSummaryServiceImpl implements TrainingSummaryService {

	private Logger logger = LoggerConfiguration.getLogger(TrainingSummaryServiceImpl.class);

	@Autowired
	private TrainingSummaryRepository trainingSummaryRepository;

	@Override
	public TrainingSummary addTrainingSummary(TrainingSummary trainingSummary) {

		logger.info("addTrainingSummary() method called from TrainingSummaryServiceImpl class");

		trainingSummary.setCreatedOn(LocalDate.now());
		return trainingSummaryRepository.save(trainingSummary);
	}

	@Override
	public List<TrainingSummary> getTrainingSummary() {

		logger.info("getTrainingSummary() method called from TrainingSummaryServiceImpl class");

		return trainingSummaryRepository.findAll();
	}

	@Override
	public TrainingSummary getById(Long trainingSummaryId) {

		logger.info("getById() method called from TrainingSummaryServiceImpl class");

		return trainingSummaryRepository.findById(trainingSummaryId)
				.orElseThrow(() -> new TrainingSummaryNotFound("This service is not found "));
	}

	@Override
	public void deleteTrainingSummary(Long trainingSummaryId) {

		logger.info("deleteTrainingSummary() method called from TrainingSummaryServiceImpl class");

		trainingSummaryRepository.findById(trainingSummaryId)
				.orElseThrow(() -> new TrainingSummaryNotFound("Training Summary for This ID is Not Found"));
		trainingSummaryRepository.deleteById(trainingSummaryId);

	}

	@Override
	public TrainingSummary updateTrainingSummary(Long trainingSummaryId, TrainingSummary trainingSummary) {

		logger.info("updateTrainingSummary() method called from TrainingSummaryServiceImpl  class");

		TrainingSummary trainingSummObj = trainingSummaryRepository.findById(trainingSummaryId)
				.orElseThrow(() -> new TrainingSummaryNotFound("Training Summary For This Id is Not Found"));

		trainingSummObj.setCreatedOn(trainingSummObj.getCreatedOn());
		trainingSummObj.setDuration(trainingSummary.getDuration());
		trainingSummObj.setTrainingPattern(trainingSummary.getTrainingPattern());
		trainingSummaryRepository.save(trainingSummObj);
		return trainingSummObj;
	}
	
	@Override
	public List<TrainingSummary> getSummaryByCreatedDateOrName(LocalDate createdOn, String trainingName) {
		List<TrainingSummary> summaryByNameOrCreatedDateList = null;
		try {
			summaryByNameOrCreatedDateList = trainingSummaryRepository.findSummaryByCreatedDateOrName(createdOn,
					trainingName);
			if (!summaryByNameOrCreatedDateList.equals(null)) {
				return summaryByNameOrCreatedDateList;
			}
		} catch (Exception e) {
			logger.error(
					"TrainingSummaryServiceImpl | getSummaryByNameOrCreatedDate | ErrorMessage: {}" + e.getMessage());
		}
		return summaryByNameOrCreatedDateList;
	}
	 
}
