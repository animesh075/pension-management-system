package com.cts.pension.pensionDisbursement.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cts.pension.pensionDisbursement.model.ProcessPensionInput;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class PensionDisbursementControllerTest {
	private static String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYxNTcyMTkxMywiaWF0IjoxNjE1NTQxOTEzfQ.sBh1dxvrhBUQWtmOIzJ0HYBIQCxZ__5Hhr1IvsOyYNI";

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private PensionDisbursementController pesionDisbursementController;

	@Test
	public void contextLoadsTestSuccess() {
		assertNotNull(pesionDisbursementController);
	}


//	@Test
//	public void disbursePensionTestSuccess() throws Exception {
//		ProcessPensionInput processPensionInput = new ProcessPensionInput("723456459012", 31050.0, 550.0);
////		ResultActions actions = mockMvc.perform(post("/disbursePension").contentType(MediaType.APPLICATION_JSON)
//		mockMvc.perform(post("/disbursePension").contentType(MediaType.APPLICATION_JSON)
//				.content(asJsonString(processPensionInput)).header("Authorization", "Bearer " + token));
//		assertEquals(10, 10);
//	
////		actions.andExpect(status().isOk());
//	}

	@Test
	public void disbursePensionTestFail() throws Exception {

		ProcessPensionInput processPensionInput1 = new ProcessPensionInput("723456459012", 31050.0, 550.0);
		ResultActions actions = mockMvc.perform(get("/disbursePension").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(processPensionInput1)).header("Authorization", "Bearer " + token));
		actions.andExpect(status().isMethodNotAllowed());

	}

//	@Test
//	public void getServiceChargeTestSuccess() throws Exception {
//
//		ResultActions actions = mockMvc.perform(post("/")
//				.contentType(MediaType.TEXT_PLAIN).content("Private").header("Authorization", "Bearer " + token));
//		actions.andExpect(status().isOk());
//		actions.andExpect(content().string("550.0"));
//
//	}
//
//	@Test
//	public void getServiceChargeTestFail() throws Exception {
//		ResultActions actions = mockMvc.perform(post("/getServiceCharge").contentType(MediaType.APPLICATION_JSON)
//				.contentType(MediaType.TEXT_PLAIN).content("Sanyam").header("Authorization", "Bearer " + token));
//		actions.andExpect(status().isOk());
//		actions.andExpect(content().contentType("application/json"));
//		actions.andExpect(content().string("500.0"));
//	}


	public static String asJsonString(ProcessPensionInput processPensionInput) {
		try {
			return new ObjectMapper().writeValueAsString(processPensionInput);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
