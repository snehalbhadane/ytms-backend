package com.yash.ytms.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.time.LocalDate;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yash.ytms.exception.TRFNotFound;
import com.yash.ytms.model.Associate;
import com.yash.ytms.model.TrainingRequestForm;
import com.yash.ytms.service.TRFService;
import com.yash.ytms.web.TRFController;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TRFController.class)
public class TRFControllerTest {
	
    @Autowired
    MockMvc mockMvc;
    
    @MockBean
    private TRFService trfService;
    
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
//		LocalDate initFrom = LocalDate.of(2023, 05, 05);
//		trf.setInitiatedFrom(initFrom);
		trf.setProjectName("CAT");
		trf.setSkillToBeImpartent("");
		trf.setNoOfParticipants(25);
//		LocalDate startDate = LocalDate.of(2023, 05, 05);
//		trf.setStartDate(startDate);
//		LocalDate endDate = LocalDate.of(2023, 07, 05);
//		trf.setEndDate(endDate);
		Associate ass = new Associate();
		ass.setEmpId((long)1016720);
		ass.setEmpName("Dheerendra kag");
		ass.setExprience((float)4.2);
		ass.setGrade("E2");
		ass.setCurrentSkill("Java");
		ass.setCurrentAllocation("CAT");
		ass.setProject("CAT");
		ass.setUpgradedSkillSet("");
		List<Associate> list = new ArrayList<>();
		list.add(ass);
		trf.setAssociates(list);
	}
	
    
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    @Test
    public void createTrfTest(){

    	when(trfService.createTRF(any())).thenReturn(trf);
    	MvcResult res = null;
        try {
			res = mockMvc.perform(MockMvcRequestBuilders.post("/trf/create")
			                                            .contentType(MediaType.APPLICATION_JSON)
			                                            .content(asJsonString(trf)))
					     .andDo(print()).andReturn();
		} catch (Exception e) {
			e.printStackTrace();
		}
        assertEquals(400, res.getResponse().getStatus());
    }

    @Test
    public void getAllTrfTest() {
    	List<TrainingRequestForm> list = new ArrayList<>();
    	list.add(trf);
    	when(trfService.getAllTrf()).thenReturn(list);
    	MvcResult res = null;
    	try {
			 res = mockMvc.perform(MockMvcRequestBuilders.get("/trf/getAllTrf"))
			              .andDo(print()).andReturn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	assertEquals(200, res.getResponse().getStatus());
    }
    
    @Test
    public void getTrfByIdTest() {
    	try {
			when(trfService.getById(any())).thenReturn(trf);
		} catch (TRFNotFound e) {
			e.printStackTrace();
		}
    	MvcResult res = null;
    	try {
			 res = mockMvc.perform(MockMvcRequestBuilders.get("/trf/getById/1"))
			              .andDo(print()).andReturn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	assertEquals(302, res.getResponse().getStatus());
    }
}
