package com.yash.ytms.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatObject;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.yash.ytms.model.Associate;
import com.yash.ytms.model.TrainingRequestForm;
import com.yash.ytms.repo.TRFRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
	class TRFRepositoryTest {
	
	@Mock
	private TRFRepository trfRepo;
	
	private TrainingRequestForm trf;
	
	@BeforeEach
	public void init() {
		trf = new TrainingRequestForm();
		trf.setTrainingTitle("Java Developer");
		trf.setTrainingType("online");
		trf.setResourceType("xyz");
		trf.setDuration(25);
		trf.setPurposeOfTraining("abc");
		LocalDate initFrom = LocalDate.of(2023, 05, 05);
		trf.setInitiatedFrom("Jaynam");
		trf.setProjectName("CAT");
		trf.setSkillToBeImpartent("");
		trf.setNoOfParticipants(25);
		LocalDate startDate = LocalDate.of(2023, 05, 05);
		trf.setStartDate(startDate);
		LocalDate endDate = LocalDate.of(2023, 07, 05);
		trf.setEndDate(endDate);
		Associate ass = new Associate();
		ass.setEmpId((long)1016720);
		ass.setEmpName("Dheerendra kag");
		ass.setExprience((float)4.2);
		ass.setGrade("E2");
		ass.setCurrentSkill("Java");
		ass.setCurrentAllocation("CAT");
		ass.setProject("CAT");
		ass.setUpgradedSkillSet("");
	}
	
	@Test
	 void createTRFTest() {

		trfRepo.save(trf);
		assertThatObject(trf).isNotNull();
	}
	
	@Test
	 void getAllTRFTest() {

		List<TrainingRequestForm> findAll = trfRepo.findAll();
		
		assertThat(findAll).isEmpty();
	}
	
	@Test
	 void getByIdTRFTest() {

		trf.setTrfId((long) 1);
		trfRepo.save(trf);
		assertThat(trf.getTrfId()).isEqualTo(1);
	}
	
	
}
