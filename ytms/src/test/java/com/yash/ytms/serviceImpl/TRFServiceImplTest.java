package com.yash.ytms.serviceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.yash.ytms.exception.TRFNotFound;
import com.yash.ytms.model.Associate;
import com.yash.ytms.model.TrainingRequestForm;
import com.yash.ytms.repo.TRFRepository;

/**
 * This class will test the TRFService
 * @author dheerendra.kag
 *
 */
@ExtendWith(MockitoExtension.class)
	class TRFServiceImplTest {

	/**
	 * This will Autowired the dependency
	 */
	@InjectMocks
	private TRFServiceImpl trfServiceImpl;
	
	@Mock
	private TRFRepository trfRepo;
	
	private TrainingRequestForm trf;
	
	/**
	 * This will execute before every test method and init the TrainingRequestForm object
	 */
	@BeforeEach
	public void init() {
		trf = new TrainingRequestForm();
		trf.setTrainingTitle("Java Developer");
		trf.setTrainingType("online");
		trf.setResourceType("xyz");
		trf.setDuration(25);
		trf.setPurposeOfTraining("abc");
		LocalDate initFrom = LocalDate.of(2023, 05, 05);
		trf.setInitiatedFrom(initFrom);
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

		when(trfRepo.save(any(TrainingRequestForm.class))).thenReturn(trf);
		TrainingRequestForm res = trfServiceImpl.createTRF(trf);
		assertThat(res).isNotNull();
	}
	
	@Test
	 void getAllTrfTest() {
		List<TrainingRequestForm> list = new ArrayList<>();
		list.add(trf);
		when(trfRepo.findAll()).thenReturn(list);
		List<TrainingRequestForm> res = trfServiceImpl.getAllTrf();
		assertThat(res).hasSize(1);
	}
	
	@Test
	 void getByIdTest() {
		when(trfRepo.findById((long)1)).thenReturn(Optional.of(trf));
		TrainingRequestForm res = null;
		try {
			 res = trfServiceImpl.getById((long)1);
		} catch (TRFNotFound e) {
			e.printStackTrace();
		}
		assertThat(res).isNotNull();
	}
	
}
