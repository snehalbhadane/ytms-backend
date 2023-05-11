package com.yash.ytms.web;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.yash.ytms.model.Role;
import com.yash.ytms.model.Trainer;
import com.yash.ytms.model.User;
import com.yash.ytms.serviceImpl.TrainerServiceImpl;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TrainerController.class)
public class TrainerControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	private TrainerServiceImpl trainerServiceImpl;

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
		user.setFirstName("Sadav");
		user.setLastName("Khan");
		user.setEmail("sadav.khan@yash.com");
		user.setRole(role);
		tr.setUser(user);
	}

	public static String asJsonString(final Object obj) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Test
	public void getTrainersTest() {

		List<Trainer> trainers = new ArrayList<Trainer>();
		
		trainers.add(tr);
		
		when(trainerServiceImpl.getTrainers()).thenReturn(trainers);
		
		MvcResult res = null;
		
		try {
			res = mockMvc.perform(MockMvcRequestBuilders.get("/trainer/getTrainers"))
			          .andDo(print()).andReturn();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(200, res.getResponse().getStatus());
	}
	
	@Test
	public void getTrainerTest() {
		
		when(trainerServiceImpl.getTrainer(any())).thenReturn(tr);
		
		MvcResult res = null;
    	try {
			 res = mockMvc.perform(MockMvcRequestBuilders.get("/trainer/getTrainer/1"))
			              .andDo(print()).andReturn();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	assertEquals(200, res.getResponse().getStatus());
	}
	
	@Test
	public void saveTest() throws Exception {
		
		when(trainerServiceImpl.saveTrainerDeatils(any())).thenReturn(tr);
		mockMvc.perform(MockMvcRequestBuilders.post("/trainer/save")
				.content(asJsonString(tr))
                .contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isCreated())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.type", is("Permanent")))
		.andExpect(jsonPath("$.irm", is("Maruti")))
		.andExpect(jsonPath("$").isNotEmpty());
	}
	
	@Test
	public void deleteTrainerTest() {
		
		when(trainerServiceImpl.getTrainer(any())).thenReturn(tr);
		
		MvcResult res = null;
    	try {
			 res = mockMvc.perform(MockMvcRequestBuilders.delete("/trainer/deleteTrainer/1"))
			              .andDo(print()).andReturn();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	assertEquals(200, res.getResponse().getStatus());
	}
}