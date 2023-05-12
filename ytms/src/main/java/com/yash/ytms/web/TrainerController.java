package com.yash.ytms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.yash.ytms.config.LoggerConfiguration;
import com.yash.ytms.model.Trainer;
import com.yash.ytms.serviceImpl.TrainerServiceImpl;

import org.slf4j.Logger;

@RestController
@RequestMapping("/trainer")
public class TrainerController {
	
	private Logger logger = LoggerConfiguration.getLogger(TrainerController.class);
	
	@Autowired
	TrainerServiceImpl trainerServiceImpl;
	
	@GetMapping("/getTrainers")
	public ResponseEntity<List<Trainer>> getTrainers() {
		
		String methodName = "getTrainers()";
		logger.info(methodName + " called from TrainerController."); 
		
		return new ResponseEntity<List<Trainer>>(trainerServiceImpl.getTrainers(), HttpStatus.OK);
	}
	
	@GetMapping("/getTrainer/{trainerId}")
	public ResponseEntity<Trainer> getTrainer(@PathVariable(value = "trainerId") Long trainerId) {
		return new ResponseEntity<Trainer>(trainerServiceImpl.getTrainer(trainerId), HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Trainer> saveTrainer(@RequestBody Trainer trainer)throws JsonParseException {
		
		String methodName = "save()";
		logger.info(methodName + " called from TrainerController." + trainer); 
		
		return new ResponseEntity<Trainer>(trainerServiceImpl.saveTrainerDeatils(trainer), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteTrainer/{trainerId}")
	public void deleteTrainer(@PathVariable(value = "trainerId") Long trainerId) {
		trainerServiceImpl.deleterainerDeatils(trainerId);
	}

}