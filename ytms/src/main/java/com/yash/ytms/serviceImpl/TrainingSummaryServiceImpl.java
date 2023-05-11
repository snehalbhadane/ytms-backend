package com.yash.ytms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ytms.model.TrainingSummary;
import com.yash.ytms.repo.TrainingSummaryRepository;
import com.yash.ytms.service.TrainingSummaryService;

@Service
public class TrainingSummaryServiceImpl  implements TrainingSummaryService{

	@Autowired
	private TrainingSummaryRepository trainingSummaryRepository;
	
	@Override
	public TrainingSummary addTrainingSummary(TrainingSummary trainingSummary) {
		
		return trainingSummaryRepository.save(trainingSummary);
	}

	@Override
	public List<TrainingSummary> getTrainingSummary() {
				return trainingSummaryRepository.findAll();
	}

}