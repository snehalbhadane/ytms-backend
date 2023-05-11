package com.yash.ytms.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ytms.exception.TrainerNotFound;
import com.yash.ytms.model.Trainer;
import com.yash.ytms.repo.TrainerRepository;
import com.yash.ytms.service.TrainerService;

@Service
public class TrainerServiceImpl implements TrainerService {
	
	@Autowired
	TrainerRepository trainerRepository;

	@Override
	public List<Trainer> getTrainers() {
		
		return trainerRepository.findAll();
	}
	
	@Override
	public Trainer getTrainer(Long trainerId) {
		return trainerRepository.findById(trainerId)
				.orElseThrow(() -> new TrainerNotFound("Trainer not found."));
	}
	
	@Override
	public Trainer saveTrainerDeatils(Trainer trainer) {
	
/*		if(trainer != null && trainer.getTrainerId() == 0) {
			//insert new record
			if(trainer.getUser() != null && trainer.getUser().getUserId() > 0) {
				
			}
			else
				throw(new TrainerNotFound("Session user not found."));
			
		} */
		
		trainer.setCreatedOn(LocalDateTime.now());
		
		return trainerRepository.save(trainer);
	}
	
	@Override
	public void deleterainerDeatils(Long trainerId) {

		trainerRepository.findById(trainerId).orElseThrow(() -> new TrainerNotFound("Trainer not found."));
		
		trainerRepository.deleteById(trainerId);
	}
}
