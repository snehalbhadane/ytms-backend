package com.yash.ytms.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.yash.ytms.config.LoggerConfiguration;
import com.yash.ytms.exception.TrainerNotFound;
import com.yash.ytms.model.Trainer;
import com.yash.ytms.model.TrainerTask;
import com.yash.ytms.repo.TrainerRepository;
import com.yash.ytms.repo.TrainerTaskRepository;
import com.yash.ytms.service.TrainerService;

/**
 * This class will responsible to implement TrainerService Interface methods
 * which going to perform with database
 * 
 * @author shubham.Bhake
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

		return trainerRepository.findById(trainerId).orElseThrow(() -> new TrainerNotFound("Trainer not found."));
	}

	/**
	 * This method will save the trainer details
	 */
	@Override
	public Trainer saveTrainerDetails(Trainer trainer) {

		/*
		 * if(trainer != null && trainer.getTrainerId() == 0) { //insert new record
		 * if(trainer.getUser() != null && trainer.getUser().getUserId() > 0) {
		 * 
		 * } else throw(new TrainerNotFound("Session user not found."));
		 * 
		 * }
		 */

		logger.info("saveTrainerDeatils(Trainer trainer) method called from TrainerServiceImpl class.");

		if (trainer.getUser() != null && trainer.getUser().getUserId() != null && trainer.getUser().getUserId() > 0) {
			trainer.setCreatedOn(LocalDateTime.now());
		} else {
			throw (new TrainerNotFound("Session user not found."));
		}

		return trainerRepository.save(trainer);
	}

	/**
	 * This method will update the trainer details
	 */
	@Override
	public Trainer updateTrainerDetails(Trainer trainer) {

		logger.info("updateTrainerDetails(Trainer trainer) method called from TrainerServiceImpl class.");

		Trainer trainerObj = new Trainer();

		if (trainer != null && trainer.getTrainerId() != null && trainer.getTrainerId() > 0) {

			trainerObj = trainerRepository.findById(trainer.getTrainerId())
					.orElseThrow(() -> new TrainerNotFound("Trainer not found."));
		} else {
			throw (new TrainerNotFound("Trainer not found."));
		}

		if (trainer.getUser() != null && trainer.getUser().getUserId() != null && trainer.getUser().getUserId() > 0) {
			trainer.setCreatedOn(trainerObj.getCreatedOn());
			trainer.setUpdatedOn(LocalDateTime.now());
		} else {
			throw (new TrainerNotFound("Session user not found."));
		}

		return trainerRepository.save(trainer);
	}

	/**
	 * This method will responsible to delete trainer details data based on
	 * trainerId
	 */
	@Override
	public void deleteTrainerDetails(Long trainerId) {

		logger.info("deleteTrainerDeatils(Long trainerId) method called from TrainerServiceImpl class.");

		trainerRepository.findById(trainerId).orElseThrow(() -> new TrainerNotFound("Trainer not found."));

		trainerRepository.deleteById(trainerId);
	}

	/**
	 * This method will responsible to fetch the all trainer task data
	 */
	@Override
	public List<TrainerTask> getTrainerTasks() {

		logger.info("getTrainerTasks() method called from TrainerServiceImpl class.");

		return trainerTaskRepository.findAll();
	}

	/**
	 * This method will responsible to fetch the all trainer task data based on
	 * created by id
	 */
	@Override
	public List<TrainerTask> getTrainerTasksByCreatedById(Long createdById) {

		logger.info("getTrainerTasksByCreatedById() method called from TrainerServiceImpl class.");

		return trainerTaskRepository.getTrainerTasksByCreatedById(createdById);
	}

	/**
	 * This method will responsible to fetch the trainer task data based on
	 * trainerTaskId
	 */
	@Override
	public TrainerTask getTrainerTask(Long trainerTaskId) {

		logger.info("getTrainerTask(Long trainerTaskId) method called from TrainerServiceImpl class.");

		return trainerTaskRepository.findById(trainerTaskId)
				.orElseThrow(() -> new TrainerNotFound("Trainer task not found."));
	}

	/**
	 * This method will responsible to save the trainer task data.
	 */
	@Override
	public TrainerTask saveTrainerTask(TrainerTask trainerTask) {

		logger.info("saveTrainerTask(TrainerTask trainerTask) method called from TrainerServiceImpl class.");

		if (trainerTask.getCreatedBy() != null && trainerTask.getCreatedBy().getUserId() != null
				&& trainerTask.getCreatedBy().getUserId() > 0) {
			trainerTask.setCreatedOn(LocalDateTime.now());
			trainerTask.setActive(true);
		} else {
			throw (new TrainerNotFound("Session user not found."));
		}

		if (trainerTask.getTrainer() != null && trainerTask.getTrainer().getTrainerId() != null
				&& trainerTask.getTrainer().getTrainerId() > 0) {

			Trainer trainer = trainerRepository.findById(trainerTask.getTrainer().getTrainerId())
					.orElseThrow(() -> new TrainerNotFound("Trainer not found. Please fill all the required details."));
			trainerTask.setTrainer(trainer);
		} else {
			throw (new TrainerNotFound("Trainer not found. Please fill all the required details."));
		}

		return trainerTaskRepository.save(trainerTask);
	}

	/**
	 * This method will responsible to update trainer task data.
	 */
	@Override
	public TrainerTask updateTrainerTask(TrainerTask trainerTask) {

		logger.info("updateTrainerTask(TrainerTask trainerTask) method called from TrainerServiceImpl class.");

		TrainerTask trainerTaskObj = new TrainerTask();

		if (trainerTask != null && trainerTask.getTrainerTaskId() != null && trainerTask.getTrainerTaskId() > 0) {

			trainerTaskObj = trainerTaskRepository.findById(trainerTask.getTrainerTaskId())
					.orElseThrow(() -> new TrainerNotFound("Trainer task not found."));
		} else {
			throw (new TrainerNotFound("Trainer task not found."));
		}

		if (trainerTask.getCreatedBy() != null && trainerTask.getCreatedBy().getUserId() != null
				&& trainerTask.getCreatedBy().getUserId() > 0) {
			trainerTask.setCreatedOn(trainerTaskObj.getCreatedOn());
			trainerTask.setUpdatedOn(LocalDateTime.now());
			trainerTask.setActive(true);
		} else {
			throw (new TrainerNotFound("Session user not found."));
		}

		if (trainerTask.getTrainer() != null && trainerTask.getTrainer().getTrainerId() != null
				&& trainerTask.getTrainer().getTrainerId() > 0) {

			Trainer trainer = trainerRepository.findById(trainerTask.getTrainer().getTrainerId())
					.orElseThrow(() -> new TrainerNotFound("Trainer not found. Please fill all the required details."));
			trainerTask.setTrainer(trainer);
		} else {
			throw (new TrainerNotFound("Trainer not found. Please fill all the required details."));
		}

		return trainerTaskRepository.save(trainerTask);
	}

	/**
	 * This method will responsible to delete trainer task details data based on
	 * trainerTaskId
	 */
	@Override
	public void deleteTrainerTask(Long trainerTaskId) {

		logger.info("deleteTrainerTask(Long trainerTaskId) method called from TrainerServiceImpl class.");

		trainerTaskRepository.findById(trainerTaskId).orElseThrow(() -> new TrainerNotFound("Trainer task not found."));

		trainerTaskRepository.deleteById(trainerTaskId);
	}

	public List<TrainerTask> getTrainerTaskswithTrainer() {
		
		TrainerServiceImpl tc= new TrainerServiceImpl();
		
	      List<TrainerTask> t1 = tc.getTrainerTasks();
	      
	    t1.forEach(e->System.out.println(e));
		 

		logger.info("getTrainerTasks() method called from TrainerServiceImpl class.");
		
		

		return null;
	}
}
