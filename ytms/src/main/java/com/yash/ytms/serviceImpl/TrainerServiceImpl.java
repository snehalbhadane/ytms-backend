package com.yash.ytms.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ytms.config.LoggerConfiguration;
import com.yash.ytms.exception.TrainerNotFound;
import com.yash.ytms.model.Trainer;
import com.yash.ytms.model.TrainerTask;
import com.yash.ytms.repo.TrainerRepository;
import com.yash.ytms.repo.TrainerTaskRepository;
import com.yash.ytms.service.TrainerService;

/**
 * This class will responsible to implement TrainerService Interface methods which going to perform with database
 * @author shubham.Bhake and Mohammad.Sadav.Khan
 * @version 1.0
 * @since 05/05/2023
 */
@Service
public class TrainerServiceImpl implements TrainerService {
	
	private Logger logger = LoggerConfiguration.getLogger(TrainerServiceImpl.class);
	
	@Autowired
	TrainerRepository trainerRepository;
	
	@Autowired
	TrainerTaskRepository trainerTaskRepository; 

	/**
	 * This method will responsible to fetch the all trainer data
	 */
	@Override
	public List<Trainer> getTrainers() {
		
		logger.info("getTrainers() method called from TrainerServiceImpl class."); 
		
		return trainerRepository.findAll();
	}
	
	/**
	 * This method will responsible to fetch the trainer data based on trainerId
	 */
	@Override
	public Trainer getTrainer(Long trainerId) {
		
		logger.info("getTrainer(Long trainerId) method called from TrainerServiceImpl class.");
		
		return trainerRepository.findById(trainerId)
				.orElseThrow(() -> new TrainerNotFound("Trainer not found."));
		
/*		return trainerRepository.findById(trainerId)
			.orElseThrow(() -> new TrainerNotFound("Trainer not found.", HttpStatus.NOT_FOUND)); */
	}
	
	/**
	 * This method will save the trainer details
	 */
	@Override
	public Trainer saveTrainerDetails(Trainer trainer) {
	
/*		if(trainer != null && trainer.getTrainerId() == 0) {
			//insert new record
			if(trainer.getUser() != null && trainer.getUser().getUserId() > 0) {
				
			}
			else
				throw(new TrainerNotFound("Session user not found."));
			
		} */
		
		logger.info("saveTrainerDeatils(Trainer trainer) method called from TrainerServiceImpl class.");
		
		trainer.setCreatedOn(LocalDateTime.now());
		
		return trainerRepository.save(trainer);
	}
	
	/**
	 * This method will responsible to delete trainer details data based on trainerId
	 */
	@Override
	public void deleteTrainerDetails(Long trainerId) {
		
		logger.info("deleteTrainerDeatils(Long trainerId) method called from TrainerServiceImpl class.");

		trainerRepository.findById(trainerId).orElseThrow(() -> new TrainerNotFound("Trainer not found."));
		
		trainerRepository.deleteById(trainerId);
	}
	
	/**
	 * This method will responsible to save the trainer task data.
	 */
	@Override
	public TrainerTask saveTrainerTask(TrainerTask trainerTask) {
		
		logger.info("saveTrainerTask(TrainerTask trainerTask) method called from TrainerServiceImpl class.");
		
		trainerTask.setCreatedOn(LocalDateTime.now());
		trainerTask.setActive(true);

		return trainerTaskRepository.save(trainerTask);
	}
}
