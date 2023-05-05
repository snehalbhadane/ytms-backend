package com.yash.ytms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yash.ytms.model.TrainingRequestForm;
import com.yash.ytms.repo.TRFRepository;
import com.yash.ytms.service.TRFService;

/**
 * This class will responsible to define the operation which going to perform with database
 * @author dheerendra.kag
 * @version 1.0
 * @since 05/05/2023
 */
@Service
public class TRFServiceImpl implements TRFService{

	/**
	 * This will inject the repository dependency
	 */
	@Autowired
	private TRFRepository trfRepository;

	/**
	 * This method will create and save the training request
	 */
	@Transactional
	@Override
	public TrainingRequestForm createTRF(TrainingRequestForm form) {
		// TODO Auto-generated method stub
		return trfRepository.save(form);
	}

	/**
	 * This method will fetch the all training request form data
	 */
	@Override
	public List<TrainingRequestForm> getAllTrf() {
		// TODO Auto-generated method stub
		return trfRepository.findAll();	
	}

	@Override
	public TrainingRequestForm getById(Long Id) {
		// TODO Auto-generated method stub
		return null;
	}
}
