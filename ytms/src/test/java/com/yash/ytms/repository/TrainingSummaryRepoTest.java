package com.yash.ytms.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatObject;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.yash.ytms.model.Role;
import com.yash.ytms.model.TrainingPlan;
import com.yash.ytms.model.TrainingRequestForm;
import com.yash.ytms.model.TrainingSummary;
import com.yash.ytms.model.User;
import com.yash.ytms.repo.TrainingSummaryRepository;

@SpringBootTest
public class TrainingSummaryRepoTest {

	@Mock
	private TrainingSummaryRepository tsmRepo;

	private TrainingSummary tSummary;

//	private TrainingPlan trainingPlan;

	/**
	 * This will execute before every test method and init the TrainingSummary
	 * object
	 */
	@BeforeEach
	public void init() {

		tSummary = new TrainingSummary();
		tSummary.setTrainingSummaryId(1L);
		tSummary.setDuration(25);
		tSummary.setTrainingPattern("Online");

		TrainingPlan trainingPlan = new TrainingPlan();

		trainingPlan.setTrainingPlanId(1l);
		trainingPlan.setTrainingName("Java Training");

		User trainer = new User();

		trainer.setEmpCode("10156");
		trainer.setDesignation("Trainer");
		trainer.setMobile("8976567889");
		trainer.setFirstName("Pooja");
		trainer.setLastName("patel");

		Role role = new Role();
		role.setRoleId(1l);
		role.setRoleName("Trainer");
		role.setRoleCode("10987");

	}

	@Test
	void createTSMTest() {

		tsmRepo.save(tSummary);
		assertThatObject(tSummary).isNotNull();
	}

	@Test
	void getAllTSMTest() {
		List<TrainingSummary> findAll = tsmRepo.findAll();

		assertThat(findAll).isEmpty();
	}

	@Test
	void getByIdTSMTest() {

		tSummary.setTrainingSummaryId(1L);
		tsmRepo.save(tSummary);
		assertThat(tSummary.getTrainingSummaryId()).isEqualTo(1);
	}

}
