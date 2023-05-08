package com.yash.ytms.service;

import java.util.List;

import com.yash.ytms.model.Trainer;

public interface TrainerService {

	public List<Trainer> getTrainers();
	
	public Trainer getTrainer(Long trainerId);
	
	public Trainer saveTrainerDeatils(Trainer trainer);

	public void deleterainerDeatils(Long trainerId);
}
