package com.yash.ytms.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.yash.ytms.config.LoggerConfiguration;
import com.yash.ytms.exception.TRFNotFound;
import com.yash.ytms.model.Associate;
import com.yash.ytms.model.TrainingRequestForm;
import com.yash.ytms.repo.AssociateRepository;
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

	private Logger logger = LoggerConfiguration.getLogger(TRFServiceImpl.class);
	
	/**
	 * This will inject the repository dependency
	 */
	@Autowired
	private TRFRepository trfRepository;

	@Autowired
	private AssociateRepository assRepository;
	
	/**
	 * This method will create and save the training request
	 */
	@Transactional
	@Override
	public TrainingRequestForm createTRF(TrainingRequestForm form) {
		form.setStatus("PENDING");
		logger.info("inside createTRF method - {} "+form);
		return trfRepository.save(form);
	}

	/**
	 * This method will fetch the all training request form data
	 */
	@Override
	public List<TrainingRequestForm> getAllTrf() {
		return trfRepository.findAll();	
	}

	/**
	 * This method will fetch the training request form by id
	 * @throws TRFNotFound will throw not found excpetion
	 */
	@Override
	public TrainingRequestForm getById(Long Id) throws TRFNotFound {
		logger.info("inside getById method - {} "+Id);
		return trfRepository.findById(Id).orElseThrow(()-> new TRFNotFound("Not Found"));
	}

	/**
	 * This method will update the existing record
	 * @throws TRFNotFound 
	 */
	@Transactional
	@Override
	public TrainingRequestForm updateTRF(Long id, TrainingRequestForm form) throws TRFNotFound {
		logger.info("inside updateTRF method - {} "+id+" training request - {} "+form);
		TrainingRequestForm rform = trfRepository.findById(id).orElseThrow(()-> new TRFNotFound("Not Found"));
		logger.info("db fetched form data - {} "+rform);
		//deleteAssosicateByIds(id, rform.getAssociates());
		rform.setTrainingTitle(form.getTrainingTitle());
        rform.setAssociates(form.getAssociates());
		rform.setTrainingType(form.getTrainingType());
		rform.setResourceType(form.getResourceType());
		rform.setDuration(form.getDuration());
		rform.setPurposeOfTraining(form.getPurposeOfTraining());
		rform.setInitiatedFrom(form.getInitiatedFrom());
		rform.setProjectName(form.getProjectName());
		rform.setSkillToBeImpartent(form.getSkillToBeImpartent());
		rform.setNoOfParticipants(form.getNoOfParticipants());
		rform.setStartDate(form.getStartDate());
		rform.setEndDate(form.getEndDate());
		rform.setCreatedBy(form.getCreatedBy());
		logger.info("going to save form data - {} "+rform);
		TrainingRequestForm res = trfRepository.save(rform);
		assRepository.deleteByIdIn();
		return res;
	}
	
	public void deleteAssosicateByIds(Long id, List<Associate> associates) {
//	    List<Long> ids = new ArrayList<>();
//	    for(Associate a : associates) {
//	    	ids.add(a.getId());
//	    }
//	    assRepository.deleteByIdIn();
	}
	@Override
	public List<TrainingRequestForm> getAllTrfByStatus(String status) {
		List<TrainingRequestForm> list = trfRepository.findAllTrainingRequestFormsByStatus(status);
		System.out.println(list.toString());
		return list;
	}

 

	@Transactional
	@Override
	public int updateTrainingRequestFormStatus(String status, Long trfId) throws TRFNotFound {
		TrainingRequestForm rform = trfRepository.findById(trfId).orElseThrow(()-> new TRFNotFound("Not Found"));
		int index = trfRepository.updateTrainingRequestFormStatus(trfId, status);
		logger.info("index of updateStatus - {} "+index);
		return index;
	}
}
