package com.yash.ytms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ytms.exception.TrainingSummaryNotFound;
import com.yash.ytms.model.TrainingPlan;
import com.yash.ytms.repo.TrainingPlanRepository;

import com.yash.ytms.service.TrainingPlanService;

@Service
public class TrainingPlanServiceImpl implements TrainingPlanService {

	@Autowired
	private TrainingPlanRepository planRepository;

	@Override
	public TrainingPlan saveTrainingPlanDetails(TrainingPlan plan) {

		return planRepository.save(plan);
	}

	@Override
	public List<TrainingPlan> getListOfTrainingPlan() {
		return this.planRepository.findAll();
	}

	@Override
	public void deleteTrainingPlanbyId(long id) {
		this.planRepository.deleteById(id);

	}

	@Override
	public TrainingPlan updateTrainingPlan(TrainingPlan plan, long id) {
		TrainingPlan existingTrainingPlan = this.planRepository.findById(id)
				.orElseThrow(() -> new TrainingSummaryNotFound("No training details found for this id"));

		existingTrainingPlan.setTrainingName(plan.getTrainingName());
		existingTrainingPlan.setTopic(plan.getTopic());
		existingTrainingPlan.setContentsCoverage(plan.getContentsCoverage());
		existingTrainingPlan.setExtraTopicCoverage(plan.getExtraTopicCoverage());
		existingTrainingPlan.setDuration(plan.getDuration());
		existingTrainingPlan.setPlannedStartDate(plan.getPlannedStartDate());
		existingTrainingPlan.setPlannedEndDate(plan.getPlannedEndDate());
		existingTrainingPlan.setActualStartDate(plan.getActualStartDate());
		existingTrainingPlan.setActualEndDate(plan.getActualEndDate());
		existingTrainingPlan.setStatus(plan.getStatus());
		existingTrainingPlan.setRemark(plan.getRemark());
		existingTrainingPlan.setUser(plan.getUser());
		existingTrainingPlan.setTrainer(plan.getTrainer());
		return planRepository.save(existingTrainingPlan);
	}

	@Override
	public TrainingPlan getTrainingPlanId(long trainingPlanId) {
		// TODO Auto-generated method stub
		return planRepository.getById(trainingPlanId);
	}

}
