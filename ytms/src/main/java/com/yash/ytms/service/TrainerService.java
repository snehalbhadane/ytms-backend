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

	public Trainer updateTrainerDetails(Trainer trainer);
	
	public Trainer updateTrainerDetails(Long trainerId ,Trainer trainer);

	public void deleteTrainerDetails(Long trainerId);

	public List<TrainerTask> getTrainerTasks();

	public List<TrainerTask> getTrainerTasksByCreatedById(Long createdById);
	
	public TrainerTask getTrainerTask(Long trainerTaskId);
	
	public TrainerTask saveTrainerTask(TrainerTask trainerTask);

	public TrainerTask updateTrainerTask(TrainerTask trainerTask);
	
	public TrainerTask updateTrainerTaskBytaskID(Long trainerTaskId,TrainerTask trainerTask);
	
	
	public void deleteTrainerTask(Long trainerTaskId);
	
	//public List<TrainerTask>getTrainerTaskswithTrainer();
	
	//public List<Trainer> getTrainersiwithTask();
}
