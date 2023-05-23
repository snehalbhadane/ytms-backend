package com.yash.ytms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yash.ytms.model.Trainer;
import com.yash.ytms.model.TrainerTask;

/**
 * This interface will responsible to declare the methods.
 * @author shubham.Bhake and Mohammad.Sadav.Khan
 * @version 1.0
 * @since 05/05/2023
 */
@Service
public interface TrainerService {

	public List<Trainer> getTrainers();
	
	public Trainer getTrainer(Long trainerId);
	
	public Trainer saveTrainerDetails(Trainer trainer);

	public void deleteTrainerDetails(Long trainerId);
	
	public TrainerTask saveTrainerTask(TrainerTask trainerTask);
}
