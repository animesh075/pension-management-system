package com.cts.pension.processPension.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.pension.processPension.model.PensionerInput;
import com.cts.pension.processPension.model.ProcessPensionInput;
import com.cts.pension.processPension.restClients.PensionDisbursementClient;
import com.cts.pension.processPension.restClients.PensionerDetailsClient;
import com.cts.pension.processPension.services.ProcessPensionService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ProcessPensionControllerTest {
	@Autowired
	ProcessPensionController processpensioncontroller;

	@Autowired
	PensionerDetailsClient pensionerDetailsClient;
	
	@Autowired
	ProcessPensionService processPensionService;
	
	PensionDisbursementClient pdc;
	
	PensionerInput pensionerInput;
	
	@Autowired
	private MockMvc mvc;

	ObjectMapper objectMapper = new ObjectMapper();
	private static String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYxNTcyMTkxMywiaWF0IjoxNjE1NTQxOTEzfQ.sBh1dxvrhBUQWtmOIzJ0HYBIQCxZ__5Hhr1IvsOyYNI";

	@Test
	public void contextLoads() {
		assertNotNull(processpensioncontroller);
	}
	
	@Test
	public void getDetailsSuccess() throws Exception {
		
		MockHttpServletRequestBuilder action = MockMvcRequestBuilders.get("/details");
		assertNotNull(action);
	}
	
	@Test
	public void getPensionerInputTestSuccess() throws Exception {
//		PensionerInput pensionerInput = new PensionerInput("ItachiUchiha","29-09-1999","KCASD1234Q","791536459012","self");
//		MockHttpServletRequestBuilder action = MockMvcRequestBuilders.post("/pensionerInput").header("Authorization", "Bearer "+token);
//		PensionDetail pensionDetail = processPensionService.getPensionDetail(
//				pensionerDetailsClient.findByAadharNumber(token, 
//						pensionerInput.getAadharNumber()), 
//				pensionerInput);
//		assertNotNull(action);
		
	}
	
	@Test
	public void getStatusCodeSuccess() {
		
		MockMvcRequestBuilders.post("/processPension").header("Authorization", "Bearer "+token);
		ProcessPensionInput processPensionInput = new ProcessPensionInput("723456459012", 31050.00, 550.0);
//		assertEquals(10,pdc.getPensionDisbursement(token, processPensionInput));
	}

//	@Test
//	public void getPensionDetailTestFail() throws Exception {
//		ResultActions actions = mvc.perform(get("/PensionDetail").param("name", "pppp")
//				.param("dateOfBirth", "27-09-1939").param("panNumber", "A123456789").param("aadharNumber", "723456459012")
//				.param("pensionType", "family").header("Authorization", "Bearer " + token));
//		actions.andExpect(status().isOk());
//	}
	@Test
	public void getProcessingCodeTestSuccess() throws Exception {
		ProcessPensionInput processPensionInput = new ProcessPensionInput("723456459012", 31050.00, 550.0);
		assertNotNull(processPensionInput) ;
		MockHttpServletRequestBuilder action = MockMvcRequestBuilders.post("/processPension").header("Authorization", "Bearer "+token);
		assertNotNull(action);
	}

}
