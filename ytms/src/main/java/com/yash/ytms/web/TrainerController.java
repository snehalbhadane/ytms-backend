                                                                                                                                                                                                                                                                                                         package com.yash.ytms.web;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.yash.ytms.config.LoggerConfiguration;
import com.yash.ytms.exception.TrainerNotFound;
import com.yash.ytms.model.Trainer;
import com.yash.ytms.model.TrainerTask;
import com.yash.ytms.service.TrainerService;

import io.swagger.annotations.ApiOperation;

/**
 * This class will responsible to handle the incoming request url and map with
 * method
 * 
 * @author shubham.Bhake
 * @version 1.0
 * @since 05/05/2023
 */
@RestController
@CrossOrigin
@RequestMapping("/trainer")
public class TrainerController {

	private Logger logger = LoggerConfiguration.getLogger(TrainerController.class);

	@Autowired
	TrainerService trainerService;

	/**
	 * This controller method handles the Get request to access list of all trainer.
	 */
	@ApiOperation(value = "fetch all trainers.")
	@GetMapping("/getTrainers")
	public ResponseEntity<List<Trainer>> getTrainers() {

		logger.info("getTrainers() method called from TrainerController class.");

		return new ResponseEntity<List<Trainer>>(trainerService.getTrainers(), HttpStatus.OK);
	}

	/**
	 * This controller method handles the Get request to access trainer based on
	 * trainer id.
	 */
	@ApiOperation(value = "fetch trainer details based on trainer id.")
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
	@ApiOperation(value = "Insert trainer details.")
	@PostMapping("/saveTrainerDetails")
	public ResponseEntity<Trainer> saveTrainer(@RequestBody Trainer trainer) throws JsonParseException {

		logger.info("saveTrainerDetails method called from TrainerController class.");

		return new ResponseEntity<Trainer>(trainerService.saveTrainerDetails(trainer), HttpStatus.CREATED);
	}

	/**
	 * This controller method handles the HTTP put request for update trainer,
	 * matching with the given URI.
	 * 
	 * @param trainer
	 */
	@ApiOperation(value = "Update trainer details.")
	@PutMapping("/updateTrainerDetails")
	public ResponseEntity<Trainer> updateTrainer(@RequestBody Trainer trainer) throws JsonParseException {

		logger.info("updateTrainer method called from TrainerController class.");

		return new ResponseEntity<Trainer>(trainerService.updateTrainerDetails(trainer), HttpStatus.CREATED);
	}

	/**
	 * This controller method handles the HTTP delete request for delete trainer
	 * details, matching with the given URI.
	 */
	@PutMapping("/updateTrainerDetail/{trainerId}")
    public ResponseEntity<Trainer>updateTrainerById(@PathVariable Long trainerId ,@RequestBody Trainer trainer){
    	logger.info("updateTrainer By id method called from TrainerController class.");
    	
	return  new ResponseEntity<Trainer>(trainerService.updateTrainerDetails(trainerId, trainer),HttpStatus.CREATED);
	
	}
	
	@ApiOperation(value = "delete trainer details based on trainer id.")
	@DeleteMapping("/deleteTrainer/{trainerId}")
	public void deleteTrainer(@PathVariable(value = "trainerId") Long trainerId) {

		logger.info("deleteTrainer/{trainerId} method called from TrainerController class.");

		trainerService.deleteTrainerDetails(trainerId);
	}

	/**
	 * This controller method handles the Get request to access list of all trainer
	 * task.
	 */
	@ApiOperation(value = "fetch all trainer tasks.")
	@GetMapping(value = "/getTrainerTasks")
	public ResponseEntity<List<TrainerTask>> getTrainerTasks() {

		logger.info("getTrainerTasks() method called from TrainerController class.");

		return new ResponseEntity<List<TrainerTask>>(trainerService.getTrainerTasks(), HttpStatus.OK);

	}

	/**
	 * This controller method handles the Get request to access list of all trainer
	 * task.
	 */
	@ApiOperation(value = "fetch all trainer tasks based on created by id.")
	@GetMapping(value = "/getTrainerTasksByCreatedById/{createdById}")
	public ResponseEntity<List<TrainerTask>> getTrainerTasksByCreatedById(
			@PathVariable(value = "createdById") Long createdById) {

		logger.info("getTrainerTasksByCreatedById() method called from TrainerController class.");

		return new ResponseEntity<List<TrainerTask>>(trainerService.getTrainerTasksByCreatedById(createdById),
				HttpStatus.OK);
	}

	/**
	 * This controller method handles the Get request to access trainer task details
	 * based on trainer task id.
	 */
	@ApiOperation(value = "fetch trainer task details based on trainer task id.")
	@GetMapping(value = "/getTrainerTask/{trainerTaskId}")
	public ResponseEntity<TrainerTask> getTrainerTask(@PathVariable(value = "trainerTaskId") Long trainerTaskId) {
		logger.info("getTrainerTask/{trainerTaskId} method called from TrainerController class.");

		return new ResponseEntity<TrainerTask>(trainerService.getTrainerTask(trainerTaskId), HttpStatus.OK);

	}

	/**
	 * This controller method handles the HTTP Post request for insert trainer task,
	 * matching with the given URI.
	 * 
	 * @param trainer task
	 */
	@ApiOperation(value = "Insert trainer task details.")
	@PostMapping("/saveTrainerTask")
	public ResponseEntity<TrainerTask> saveTrainerTask(@RequestBody TrainerTask trainerTask) throws JsonParseException {

		logger.info("saveTrainerTask method called from TrainerController class.");

		return new ResponseEntity<TrainerTask>(trainerService.saveTrainerTask(trainerTask), HttpStatus.CREATED);
	}

	/**
	 * This controller method handles the HTTP put request for update trainer task,
	 * matching with the given URI.
	 * 
	 * @param trainer task
	 */
	@ApiOperation(value = "Update trainer task details.")
	@PutMapping("/updateTrainerTask")
	public ResponseEntity<TrainerTask> updateTrainerTask(@RequestBody TrainerTask trainerTask)
			throws JsonParseException {

		logger.info("updateTrainerTask method called from TrainerController class.");

		return new ResponseEntity<TrainerTask>(trainerService.updateTrainerTask(trainerTask), HttpStatus.CREATED);
	}

	/**
	 * This controller method handles the HTTP delete request for delete trainer
	 * task details, matching with the given URI.
	 */
	@ApiOperation(value = "delete trainer task details based on trainer task id.")
	@DeleteMapping("/deleteTrainerTask/{trainerTaskId}")
	public void deleteTrainerTask(@PathVariable(value = "trainerTaskId") Long trainerTaskId) {

		logger.info("deleteTrainerTask/{trainerTaskId} method called from TrainerController class.");
		logger.info("deleteTrainerTask/{trainerTaskId} method called from TrainerController class2.");

		trainerService.deleteTrainerTask(trainerTaskId);
	}

	/*
	 * @ApiOperation(value = "fetch all trainer tasks.")
	 * 
	 * @GetMapping(value = "/getTrainerTasksNames") public
	 * ResponseEntity<List<TrainerTask>> getTrainerTaskswithname() {
	 * 
	 * 
	 * 
	 * return null;
	 * 
	 * }
	 */

}
