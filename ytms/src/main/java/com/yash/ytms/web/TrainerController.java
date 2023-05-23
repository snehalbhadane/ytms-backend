package com.yash.ytms.web;

import java.util.List;

import org.slf4j.Logger;
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
import com.yash.ytms.model.TrainerTask;
import com.yash.ytms.service.TrainerService;

/**
 * This class will responsible to handle the incoming request url and map with method
 * @author shubham.Bhake and Mohammad.Sadav.Khan
 * @version 1.0
 * @since 05/05/2023
 */
@RestController
@RequestMapping("/trainer")
public class TrainerController {

	private Logger logger = LoggerConfiguration.getLogger(TrainerController.class);

	@Autowired
	TrainerService trainerService;

	/**
	 * This controller method handles the Get request to access list of all 
	 * trainer.
	 */
	@GetMapping("/getTrainers")
	public ResponseEntity<List<Trainer>> getTrainers() {

		logger.info("getTrainers() method called from TrainerController class.");

		return new ResponseEntity<List<Trainer>>(trainerService.getTrainers(), HttpStatus.OK);
	}
	
	/**
	 * This controller method handles the Get request to access 
	 * trainer based on trainer id.
	 */
	@GetMapping("/getTrainer/{trainerId}")
	public ResponseEntity<Trainer> getTrainer(@PathVariable(value = "trainerId") Long trainerId) {

		logger.info("getTrainer/{trainerId} method called from TrainerController class.");

		return new ResponseEntity<Trainer>(trainerService.getTrainer(trainerId), HttpStatus.OK);
	}

	/**
	 * This controller method handles the HTTP Post request for insert trainer,
	 * matching with the given URI.
	 * 
	 * @param trainer
	 */
	@PostMapping("/saveTrainerDetails")
	public ResponseEntity<Trainer> saveTrainer(@RequestBody Trainer trainer) throws JsonParseException {

		logger.info("saveTrainerDetails method called from TrainerController class.");

		return new ResponseEntity<Trainer>(trainerService.saveTrainerDetails(trainer), HttpStatus.CREATED);
	}

	/**
	 * This controller method handles the HTTP delete request for delete trainer details,
	 * matching with the given URI.
	 * 
	 * @param trainer
	 */
	@DeleteMapping("/deleteTrainer/{trainerId}")
	public void deleteTrainer(@PathVariable(value = "trainerId") Long trainerId) {

		logger.info("deleteTrainer/{trainerId} method called from TrainerController class.");

		trainerService.deleteTrainerDetails(trainerId);
	}
	
	/**
	 * This controller method handles the HTTP Post request for insert trainer task,
	 * matching with the given URI.
	 * 
	 * @param trainer task
	 */
	@PostMapping("/saveTrainerTask")
	public ResponseEntity<TrainerTask> saveTrainerTask(@RequestBody TrainerTask trainerTask) throws JsonParseException {
		
		logger.info("saveTrainerTask method called from TrainerController class.");
		
		return new ResponseEntity<TrainerTask>(trainerService.saveTrainerTask(trainerTask), HttpStatus.CREATED);
	}
}