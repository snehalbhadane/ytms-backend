package com.yash.ytms.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.yash.ytms.model.Role;
import com.yash.ytms.model.Trainer;
import com.yash.ytms.model.User;
import com.yash.ytms.repo.TrainerRepository;

/*
 * To Test saveTrainer(),getTrainers(),getTrainerById(),deleteTrainebyId()
 * of service layer
 * 
 * @author shubham.Bhake
 * @author Mohammad.Sadav.Khan
 * 
 *  if the beginning of the specified string cannot be
 * parsed then it throws ParseException
 */

@SpringBootTest(classes = { TrainerServiceImplTest.class })
class TrainerServiceImplTest {

	@Mock
	TrainerRepository trainerRepository;

	@InjectMocks
	TrainerServiceImpl trainerServiceImpl;

	Role role = new Role(1L, "TR", "Trainer");

	LocalDateTime createdOndate = LocalDateTime.now();
	LocalDateTime updatedOndate = LocalDateTime.now();

	String dob = "01/17/1995";

	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

	User user;

	Trainer trainer;

	Trainer trainer1;

	@BeforeEach
	public void intialSetup() throws ParseException {

		user = new User(1L, "101", "Shubham", "Bhake", "shubham@gmail.com", "1234567890", "1234567890", "male",
				formatter.parse(dob), "2.10 year", role, "Pune", "ytms", "software Enginner", createdOndate,
				updatedOndate, null);

		trainer = new Trainer(1L, user, "pune", "Hinjewadi", "mamta", "permenat", "3year", createdOndate,
				updatedOndate);

		trainer1 = new Trainer(1L, user, "pune", "Hinjewadi", "mamta", "permenat", "3year", createdOndate,
				updatedOndate);
	}

	@Test
	public void saveTrainerTest() throws Exception {

		when(trainerRepository.save(trainer)).thenReturn(trainer);

		assertEquals(trainer, trainerServiceImpl.saveTrainerDetails(trainer));

		assertEquals(1234567890, trainerServiceImpl.saveTrainerDetails(trainer).getUser().getMobile());

		assertEquals("Shubham", trainerServiceImpl.saveTrainerDetails(trainer).getUser().getFirstName());
	}

	@Test
	public void getTrainersTest() throws ParseException {

		User user1 = new User(1L, "101", "Shubham", "Bhake", "shubham@gmail.com", "1234567890", "1234567890", "male",
				formatter.parse(dob), "2.10 year", role, "Pune", "ytms", "software Enginner", createdOndate,
				updatedOndate, null);

		Trainer trainer11 = new Trainer(1L, user1, "pune", "Hinjewadi", "mamta", "permenat", "3year", createdOndate,
				updatedOndate);
		Trainer trainer12 = new Trainer(1L, user1, "Indor", "Super_Coridor", "mamta", "permenat", "3year",
				createdOndate, updatedOndate);

		ArrayList<Trainer> TL = new ArrayList<>();

		TL.add(trainer11);
		TL.add(trainer12);

		when(trainerRepository.findAll()).thenReturn(TL);

		assertEquals(2, trainerServiceImpl.getTrainers().size());

	}

	@Test
	public void getTrainerByIdTest() throws ParseException {

		when(trainerRepository.findById(trainer.getTrainerId())).thenReturn(Optional.of(trainer));

		assertEquals(1L, trainer.getTrainerId());
		assertEquals("permenat", trainer.getType());
	}

	@Test
	public void deleteTrainerDetailsTest() throws ParseException {

		Trainer trainerr = new Trainer(1L, user, "pune", "Hinjewadi", "mamta", "permenat", "3year", createdOndate,
				updatedOndate);

		long trainerId = trainerr.getTrainerId();

		when(trainerRepository.findById(trainerId)).thenReturn(Optional.of(trainerr));

		trainerServiceImpl.deleteTrainerDetails(trainerId);

		verify(trainerRepository, times(1)).deleteById(trainerId);

	}

}
