package com.cts.pension.pensionerDetail.controller;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class PensionerDetailsControllerTests {

	private static String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYxNTcyMTkxMywiaWF0IjoxNjE1NTQxOTEzfQ.sBh1dxvrhBUQWtmOIzJ0HYBIQCxZ__5Hhr1IvsOyYNI";
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private PensionerDetailsController pensionerDetailsController;

	@Test
	public void contextLoads() {

		assertNotNull(pensionerDetailsController);

	}

	@Test
	public void pensionerDetailSuccess() throws Exception {
		ResultActions actions = mockMvc.perform(get("/allDetails"));

		actions.andExpect(status().isOk());
//		actions.andExpect(jsonPath("$.aadharNumber").exists());
//		actions.andExpect(jsonPath("$.aadharNumber").value("123456789012"));
	}
//	@Test
//	public static void pensionerDetailByAadharTestFailure() throws Exception {
//		
//		ResultActions actions = (ResultActions) MockMvcRequestBuilders
//				.get("/pensionerList/123456789012")
//				.accept(MediaType.APPLICATION_JSON)
//				.header(HttpHeaders.AUTHORIZATION,"Bearer token");
//		
//		actions.andExpect(status().isForbidden());
//	}

	@Test
	public void pensionerDetailByAadhaarTestSuccess() throws Exception {

		 MockMvcRequestBuilders.get("/pensionerList/123456789012").header("Authorization",
				"Bearer " + token);

		// ResultActions actions = (ResultActions) MockMvcRequestBuilders
//				.get("/pensionerList/123456789012")
//						.accept(MediaType.APPLICATION_JSON)
//						.header(HttpHeaders.AUTHORIZATION, "Bearer " + token);
//
//		((ResultActions) actions).andExpect(status().isOk());
//		actions.andExpect(jsonPath("$.aadharNumber").exists());
//		actions.andExpect(jsonPath("$.aadharNumber").value("123456789012"));
	}

	@Test
	public void pensionerDetailByAadhaarTestFailure() throws Exception {

		MockMvcRequestBuilders.get("/pensionerList/123456789012").header("Authorization", "Bearer token");
	}

	@Test
	public void pensionerDeleteByAadhaarTestSuccess() throws Exception {

		MockMvcRequestBuilders.delete("/pensionerList/123456789012").header("Authorization", "Bearer " + token);
	}

	@Test
	public void pensionerDeleteByAadhaarTestFailure() throws Exception {

		MockMvcRequestBuilders.delete("/pensionerList/123456789012").header("Authorization", "Bearer token");
	}

}
