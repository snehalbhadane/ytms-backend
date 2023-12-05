package com.yash.ytms.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.apache.tomcat.util.json.ParseException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yash.ytms.model.Role;
import com.yash.ytms.model.TrainingPlan;
import com.yash.ytms.model.TrainingSummary;
import com.yash.ytms.model.User;
import com.yash.ytms.service.TrainingSummaryService;

@WebMvcTest(TrainingSummaryController.class)
@ExtendWith(SpringExtension.class)
public class TrainingSummaryControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private TrainingSummaryService service;
	
	private TrainingSummary tSummary;
	
	@BeforeEach
	public void init() throws ParseException {
		tSummary=new TrainingSummary();
		
		tSummary=new TrainingSummary();
		tSummary.setTrainingSummaryId(1L);
		tSummary.setDuration(25);
		tSummary.setTrainingPattern("Online");
		
		TrainingPlan trainingPlan=new TrainingPlan();
		
		trainingPlan.setTrainingPlanId(1l);
		trainingPlan.setTrainingName("Java");
		
		tSummary.setTrainingPlan(trainingPlan);
		
	
		User trainer=new User();
		
		trainer.setEmpCode("10156");
		trainer.setDesignation("Trainer");
		trainer.setMobile("8976567889");
		trainer.setFirstName("Pooja");
		trainer.setLastName("patel");
		trainer.setEmail("pooja.patel@yash.com");
		trainer.setLocation("Pune magarpatta");
		trainer.setExperience("6.9");
		
		Role role=new Role();
		role.setRoleId(1l);
		role.setRoleName("Trainer");
		role.setRoleCode("10987");
		
		tSummary.setTrainer(trainer);
		
		
	}
	
	@Test
	void createTSTest() throws JsonProcessingException, Exception {
		
		when(service.addTrainingSummary(tSummary)).thenReturn(tSummary);
		
		mockMvc.perform(post("/tsm/addSummary")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(tSummary))
				).andExpect(status().isCreated());
		
	}
	
	@Test
	void createAllTrainingSummaryTest() throws Exception {
		
		MvcResult mvcResult;
		
		List<TrainingSummary> summarylist = Arrays.asList(tSummary);
		
		when(service.getTrainingSummary()).thenReturn(summarylist);
		
		
		mvcResult=mockMvc.perform(MockMvcRequestBuilders.get("/tsm/getTrainigSummaryDetails"))
		.andDo(print()).andReturn();
		
		assertEquals(200, mvcResult.getResponse().getStatus());
		
	}
	
}
