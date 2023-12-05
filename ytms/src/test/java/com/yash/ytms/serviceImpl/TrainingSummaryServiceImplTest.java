package com.yash.ytms.serviceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.yash.ytms.exception.TRFNotFound;
import com.yash.ytms.exception.TrainingSummaryNotFound;
import com.yash.ytms.model.Role;
import com.yash.ytms.model.TrainingPlan;
import com.yash.ytms.model.TrainingRequestForm;
import com.yash.ytms.model.TrainingSummary;
import com.yash.ytms.model.User;
import com.yash.ytms.repo.TrainingSummaryRepository;

@SpringBootTest
public class TrainingSummaryServiceImplTest {

	@Mock
	private TrainingSummaryRepository tsmRepo;

	@InjectMocks
	private TrainingSummaryServiceImpl tsImpl;

	private TrainingSummary tSummary;

	LocalDate createdOndate = LocalDate.now();

	User user;
	TrainingPlan trainingPlan;

	TrainingSummary trainingSummary;

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
		trainer.setEmail("pooja.patel@yash.com");
		trainer.setLocation("Pune magarpatta");
		trainer.setExperience("6.9");

		Role role = new Role();
		role.setRoleId(1l);
		role.setRoleName("Trainer");
		role.setRoleCode("10987");

	}

	@Test
	void createTSMTest() {

		when(tsmRepo.save(any(TrainingSummary.class))).thenReturn(tSummary);
		TrainingSummary addTrainingSummary = tsImpl.addTrainingSummary(tSummary);
		assertThat(addTrainingSummary).isNotNull();
	}

	@Test
	void getAllTSMTest() {
		List<TrainingSummary> list = new ArrayList<>();
		list.add(tSummary);
		when(tsmRepo.findAll()).thenReturn(list);
		List<TrainingSummary> trainingSummary = tsImpl.getTrainingSummary();
		assertThat(trainingSummary).hasSize(1);
	}

	@Test
	void getByIdTest() {
		when(tsmRepo.findById((long) 1)).thenReturn(Optional.of(tSummary));
		TrainingSummary res = null;
		try {
			res = tsImpl.getById(1L);
		} catch (TrainingSummaryNotFound e) {
			e.printStackTrace();
		}
		assertThat(res).isNotNull();
	}

	@Test
	public void deleteTrainingSummaryTest() {
		TrainingSummary trainingSummary2 = new TrainingSummary(1L, trainingPlan, user, "online", 20, createdOndate);

		long summaryId = trainingSummary2.getTrainingSummaryId();
		when(tsmRepo.findById(summaryId)).thenReturn(Optional.of(trainingSummary2));
		tsImpl.deleteTrainingSummary(summaryId);
		verify(tsmRepo, times(1)).deleteById(summaryId);
	}

}
