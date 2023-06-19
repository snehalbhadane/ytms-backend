package com.yash.ytms.web;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.yash.ytms.exception.TRFNotFound;
import com.yash.ytms.model.Associate;
import com.yash.ytms.model.TrainingRequestForm;
import com.yash.ytms.service.TRFService;

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
		List<Associate> list = new ArrayList<>();
		list.add(ass);
		trf.setAssociates(list);
	}
	
    
    public static String asJsonString(final Object obj) {
        try {
        	ObjectMapper mapper = new ObjectMapper();
        	mapper.registerModule(new JavaTimeModule());
        	mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    @Disabled
    @Test
    public void createTrfTest() throws Exception{

    	when(trfService.createTRF(any())).thenReturn(trf);
        mockMvc.perform(MockMvcRequestBuilders.
                post("/trf/create")
                    .content(asJsonString(trf))
                    .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.trainingType", is("online")))
                .andExpect(jsonPath("$.initiatedFrom", is("2023-05-05")))
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Disabled
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
    
    @Disabled
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
    
    @Disabled
    @Test
    public void getTrfByIdTestTRFNotFoundException() throws Exception {
    	try {
			when(trfService.getById(any())).thenThrow(new TRFNotFound("Not Found"));
		} catch (TRFNotFound e) {
			e.printStackTrace();
		}
        mockMvc.perform(MockMvcRequestBuilders.get("/trf/getById/1"))
                .andDo(print())
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$.error").value("Not Found"));

    }
    
    @Test
    public void updateTRFTest() throws Exception{

    	when(trfService.updateTRF(anyLong(), any())).thenReturn(trf);
        mockMvc.perform(MockMvcRequestBuilders.
                put("/trf/update/1")
                    .content(asJsonString(trf))
                    .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.trainingType", is("online")))
                .andExpect(jsonPath("$.initiatedFrom", is("2023-05-05")))
                .andExpect(jsonPath("$").isNotEmpty());
    }
}
