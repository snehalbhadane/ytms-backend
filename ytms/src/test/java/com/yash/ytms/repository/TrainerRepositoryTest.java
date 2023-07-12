package com.yash.ytms.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatObject;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.yash.ytms.model.Role;
import com.yash.ytms.model.Trainer;
import com.yash.ytms.model.User;
import com.yash.ytms.repo.TrainerRepository;

@SpringBootTest
public class TrainerRepositoryTest {

	@Mock
	private TrainerRepository trainerRepository;

	private Trainer tr;

	@BeforeEach
	public void init() {
		tr = new Trainer();

		tr.setCurrentLocation("Pune");
		tr.setBaseLocation("Bangalore");
		tr.setIrm("Maruti");
		tr.setType("Permanent");
		tr.setTotalExperience("2.5Years");
		LocalDateTime createdDate = LocalDateTime.of(2023, 05, 05, 12, 26, 45);
		tr.setCreatedOn(createdDate);

		Role role = new Role();
		role.setRoleId(1L);
		role.setRoleName("Trainer");
		role.setRoleCode("TR");

		User user = new User();
		user.setEmpCode("101");
		user.setFirstName("Shubham");
		user.setLastName("Bhake");
		user.setEmail("Shubham@yash.com");
		user.setRole(role);
		tr.setUser(user);
	}

	@Disabled
	@Test
	public void getTrainersTest() {

		List<Trainer> trainers = trainerRepository.findAll();

		assertThat(trainers).isEmpty();
	}

	@Disabled
	@Test
	public void getTrainerByIdTest() {
		tr.setTrainerId(1l);
		trainerRepository.save(tr);

		Optional<Trainer> trObj = trainerRepository.findById(tr.getTrainerId());

		assertThat(trObj).isNotNull();
	}

	@Disabled
	@Test
	public void saveTrainerDeatilsTest() {
		trainerRepository.save(tr);
		assertThatObject(tr).isNotNull();
	}
}
