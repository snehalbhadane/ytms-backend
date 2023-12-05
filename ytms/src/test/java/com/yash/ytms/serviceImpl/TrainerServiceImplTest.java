package com.yash.ytms.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.yash.ytms.model.Role;
import com.yash.ytms.model.Trainer;
import com.yash.ytms.model.TrainerTask;
import com.yash.ytms.model.User;
import com.yash.ytms.repo.TrainerRepository;
import com.yash.ytms.repo.TrainerTaskRepository;

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
	
	@Mock
	TrainerTaskRepository trainerTaskRepository;

	@InjectMocks
	TrainerServiceImpl trainerServiceImpl;

	Role role = new Role(1L, "TR", "Trainer");

	LocalDateTime createdOndate = LocalDateTime.now();
	LocalDateTime updatedOndate = LocalDateTime.now();

	String dob = "01/17/1995";
	String taskDate= "30/6/2023";
	boolean active=true;

	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

	User user;

	Trainer trainer;

	Trainer trainer1;
	Trainer trainer3;
	
	TrainerTask trainerTask;

	@BeforeEach
	public void intialSetup() throws ParseException {

		user = new User(1L, "101", "Shubham", "Bhake", "shubham@gmail.com", "1234567890", "1234567890", "male",
				formatter.parse(dob), "2.10 year", role, "Pune", "ytms", "software Enginner", createdOndate,
				updatedOndate, null);

		trainer = new Trainer(1L, user, "pune", "Hinjewadi", "mamta", "permenat", "3year", createdOndate,
				updatedOndate);

		trainer1 = new Trainer(1L, user, "pune", "Hinjewadi", "mamta", "permenat", "3year", createdOndate,
				updatedOndate);
		
		trainer3 = new Trainer(1L, user, "pune", "Hinjewadi", "mamta", "permenat", "3year", createdOndate,
				updatedOndate);
		
		
		trainerTask =new TrainerTask(1L,null,"Availble", "No assignment","Engaged", "Microservises Training",
				                    user,trainer3,createdOndate, createdOndate,true);
	}

	@Test
	public void saveTrainerTest() throws Exception {

		when(trainerRepository.save(trainer)).thenReturn(trainer);

		assertEquals(trainer, trainerServiceImpl.saveTrainerDetails(trainer));

		assertEquals("1234567890", trainerServiceImpl.saveTrainerDetails(trainer).getUser().getMobile());

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
    public void updateTrainerById() throws ParseException {
		
		User user1 = new User(1L, "101", "Shubham", "Bhake", "shubham@gmail.com", "1234567890", "1234567890", "male",
				formatter.parse(dob), "2.10 year", role, "Pune", "ytms", "software Enginner", createdOndate,
				updatedOndate, null);

		Trainer trainer11 = new Trainer(1L, user1, "pune", "Hinjewadi", "mamta", "permenat", "3year", createdOndate,
				updatedOndate);
		
		
		//Trainer trainerAvaible = new Trainer();
		trainer11.setTrainerId(1L);
		
		trainer11.setIrm("Maruti");
		trainer11.setCurrentLocation("Nagpur");
		
		
		Trainer trainerupdate=this.trainerRepository.save(trainer11);

		assertEquals("Maruti",trainer11.getIrm());
		assertEquals("Nagpur",trainer11.getCurrentLocation());
			
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
	//-------------------------------------------------------------------------------------------------------
	
   /* @Test
	public void saveTrainerTaskTest() throws ParseException{
		
	when(trainerTaskRepository.save(trainerTask)).thenReturn(trainerTask);
	
	assertEquals(trainerTask, trainerServiceImpl.saveTrainerTask(trainerTask));
	
	
}*/
		
	@Test
	public void getTrainerTaskTest() throws ParseException {
		
		user = new User(1L, "101", "Shubham", "Bhake", "shubham@gmail.com", "1234567890", "1234567890", "male",
				formatter.parse(dob), "2.10 year", role, "Pune", "ytms", "software Enginner", createdOndate,
				updatedOndate, null);
		
		TrainerTask trainerTask1 =new TrainerTask(1L,null,"Availble", "No assignment","Engaged", "Microservises Training",
                user,trainer3,createdOndate, createdOndate,true);
		
		TrainerTask trainerTask2 =new TrainerTask(1L,null,"Availble", "No assignment","Engaged", "Microservises Training",
                user,trainer3,createdOndate, createdOndate,true);
		
		ArrayList<TrainerTask>TS=new ArrayList<>();
		TS.add(trainerTask1);
		TS.add(trainerTask1);
		
		
		when(trainerTaskRepository.findAll()).thenReturn(TS);
		
		assertEquals(2, trainerServiceImpl.getTrainerTasks().size());
	}
	
	@Test
	public void getTrainerTaskByIdTest() throws ParseException {

		when(trainerTaskRepository.findById(trainerTask.getTrainerTaskId())).thenReturn(Optional.of(trainerTask));

		assertEquals(1L, trainerTask.getTrainerTaskId());
		assertEquals("Availble", trainerTask.getFirstHalf());
		assertEquals("Microservises Training",trainerTask.getSecondHalfDescription());
	}
  /*  @Test
	public void getTrainerTasksByCreatedById() {
	
		//when(trainerTaskRepository.getTrainerTasksByCreatedById(trainerTask.getCreatedBy())).thenReturn(trainerTask);
	
		User u=trainerTask.getCreatedBy();
		Long id =	u.getUserId();
		
	when(trainerTaskRepository.getTrainerTasksByCreatedById(id));
	
	assertEquals("Availble", trainerTask.getFirstHalf());
	}*/
    
    @Test
    public void deleteTrainerTask() {
    	
    	TrainerTask trainerTask2 =new TrainerTask(1L,null,"Availble", "No assignment","Engaged", "Microservises Training",
                user,trainer3,createdOndate, createdOndate,true);
    	
    	long taskid=trainerTask.getTrainerTaskId();
    	
		
		when(trainerTaskRepository.findById(taskid)).thenReturn(Optional.of(trainerTask));
		
		trainerServiceImpl.deleteTrainerTask(taskid);
		
		verify(trainerTaskRepository,times(1)).deleteById(taskid);
		
    }
    
    
}

