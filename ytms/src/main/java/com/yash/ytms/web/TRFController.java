package com.yash.ytms.web;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ytms.config.LoggerConfiguration;
import com.yash.ytms.exception.TRFNotFound;
import com.yash.ytms.model.TrainingRequestForm;
import com.yash.ytms.service.TRFService;

/**
 * This class will responsible to handle the incoming request url and map with method
 * @author dheerendra.kag
 * @version 1.0
 * @since 05/05/2023
 */
@CrossOrigin
@RestController
@RequestMapping("/trf")
public class TRFController {

	private Logger logger = LoggerConfiguration.getLogger(TRFController.class);
	
	/**
	 * This will inject the service dependency
	 */
	@Autowired
	private TRFService trfService;
	
	/**
	 * This will map the incoming create request
	 * @param form will handle the TrainingRequestForm metadata
	 * @return the created request with id
	 */
	@PostMapping("/create")
	public ResponseEntity<TrainingRequestForm> createTrf(@Valid @RequestBody(required=false) TrainingRequestForm form){
		logger.info("inside createTrf method - {} "+form);
		return new ResponseEntity<>(trfService.createTRF(form), HttpStatus.CREATED);
	}
	
	/**
	 * This will map the request and return the list of training request form 
	 * @return the list of training request form
	 */
	@GetMapping("/getAllTrf")
	public ResponseEntity<List<TrainingRequestForm>> getAllTrf(){
		return new ResponseEntity<>(trfService.getAllTrf(),HttpStatus.OK);
	}
	
	/**
	 * This will map the coming request with id and return the training request form 
	 * @param id is training request form id
	 * @return the training request form
	 * @throws TRFNotFound 
	 */
	@GetMapping("/getById/{id}")
	public ResponseEntity<TrainingRequestForm> getTrfById(@PathVariable("id") Long id) throws TRFNotFound{
		logger.info("inside getTrfById method - {} "+id);
		return new ResponseEntity<>(trfService.getById(id),HttpStatus.OK);
    }
	
	/**
	 * This will update the existing record by id
	 * @param id contain the record id which we want to update
	 * @param form new training request form data
	 * @return save record will return with created id
	 * @throws TRFNotFound if not found record then throws the exception
	 */
	@PutMapping("/update/{id}")
	public ResponseEntity<TrainingRequestForm> updateTRF(@PathVariable("id") Long id, @Valid @RequestBody TrainingRequestForm form) throws TRFNotFound{
		logger.info("inside getTrfById method id - {} "+id+" training request - {} "+form);
		return new ResponseEntity<>(trfService.updateTRF(id, form), HttpStatus.OK);
	}
	
	@GetMapping("/getTrfByStatus")
	public ResponseEntity<List<TrainingRequestForm>> getTrfByStatus(@RequestParam("status") String status){
		logger.info("inside getTrfByIdStatus method - {} "+status);
		return new ResponseEntity<List<TrainingRequestForm>>(trfService.getAllTrfByStatus(status),HttpStatus.OK);
    }

	@GetMapping("/updateTrfStatus")
	public ResponseEntity<?> updateTrfStatus(@RequestParam("status") String status, @RequestParam("trfId") Long trfId) throws TRFNotFound{
		logger.info("inside updateTrfStatus method - {} "+status);
		return new ResponseEntity<>(trfService.updateTrainingRequestFormStatus(status, trfId),HttpStatus.OK);
    }
}
