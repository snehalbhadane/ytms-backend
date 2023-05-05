package com.yash.ytms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ytms.model.Trainer;
import com.yash.ytms.repo.TrainerRepository;
import com.yash.ytms.service.TrainerService;

@Service
public class TrainerServiceImpl implements TrainerService {
	
	@Autowired
	TrainerRepository rainerRepository;

	@Override
	public Trainer saveTrainerDeatils(Trainer trainer) {
		// TODO Auto-generated method stub
		System.out.println(trainer);
		return rainerRepository.save(trainer);
	}

}
