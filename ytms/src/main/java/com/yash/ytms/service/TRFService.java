package com.yash.ytms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yash.ytms.model.TrainingRequestForm;

/**
 * This class will responsible to declare the operation which will going to perform with database table
 * @author dheerendra.kag
 * @version 1.0
 * @since 05/05/2023
 */
@Service
public interface TRFService {

	public TrainingRequestForm createTRF(TrainingRequestForm form);
	public List<TrainingRequestForm> getAllTrf();
	public TrainingRequestForm getById(Long Id);
}
