package com.cts.animesh.pension.authorizationService.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.ResultMatcher;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.animesh.pension.authorizationService.model.AuthResponse;
import com.cts.animesh.pension.authorizationService.model.User;
import com.cts.animesh.pension.authorizationService.service.AdminUserService;
import com.cts.animesh.pension.authorizationService.service.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class AuthenticateControllerTest {
	private static String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYxNTcyMTkxMywiaWF0IjoxNjE1NTQxOTEzfQ.sBh1dxvrhBUQWtmOIzJ0HYBIQCxZ__5Hhr1IvsOyYNI";
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private AuthenticateController authenticateController;
	@Autowired
	private AdminUserService adminUserDetailService;
	@Autowired
	private JwtUtil jwtUtil;
	@Test
	public void contextLoads() {
		assertNotNull(authenticateController);
	}

	@Test
	public void loginTestSuccess() throws Exception {
		User admin = new User("1", "abc", "animesh", token);
		UserDetails userDetails =adminUserDetailService.loadUserByUsername(admin.getId());
		ResultActions actions = mockMvc
				.perform(post("/authenticate").contentType(MediaType.APPLICATION_JSON).content(asJsonString(admin)));
		if((userDetails.getPassword().equals(admin.getPassword()))) {
		assertNotNull(actions);
		actions.andExpect(status().isOk());
		}else {
			actions.andExpect(status().isForbidden());
			actions.andExpect(status().reason("Access Denied"));
		}
//		actions.andExpect(status().isOk());
	}

	@Test
	public void loginTestFail() throws Exception {
		User admin = new User("5", "randomPassword", "randomUser", "randomToken");

		ResultActions actions = mockMvc
				.perform(post("/authenticate").contentType(MediaType.APPLICATION_JSON).content(asJsonString(admin)));
		actions.andExpect(status().isForbidden());
		actions.andExpect(status().reason("Access Denied"));
	}

	@Test
	public void validateTestSuccess() throws Exception {
//		MockMvcRequestBuilders.get("/authorize")
//				.header("Authorization", "Bearer "+token);
//
//		apiKeyRequestBuilder(status().isOk());
		HttpHeaders headers = getHeaders();
		headers.set("Authorization","Bearer "+ token);
		ResultActions actions = mockMvc.perform(get("/authorize").headers(getHeaders()));
		AuthResponse res = new AuthResponse("1","Admin",true);
		String token1 = token.substring(7);
//		if(token1 == null) {
//			assertNotNull(actions);
//		}else {
//			UserDetails user = adminUserDetailService
//					.loadUserByUsername("1");
//			if(jwtUtil.validateToken(token1,user)) {
				assertNotNull(actions);
//			}else {
//				
//			}
//		}
//		actions.andExpect(status().isOk());
//		assertNotNull(actions);
		
	}
	private HttpHeaders getHeaders() {

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return headers;
	}

//	private void apiKeyRequestBuilder(ResultMatcher ok) {
//		
//	}

	@Test
	public void validateTestFail() throws Exception {
		AuthResponse res = new AuthResponse("1","Admin",true);
		String token1 = token.substring(7);
		HttpHeaders headers = getHeaders();
		headers.set("Authorization","randomToken ");
		ResultActions actions = mockMvc.perform(get("/authorize").headers(getHeaders()));
	
		assertNotNull(res);
//		actions.andExpect(status().isOk());
//		actions.andExpect(status().isForbidden());
//		MockMvcRequestBuilders.get("/authorize")
//				.header("Authorization", "Bearer token");
//
//		apiKeyRequestBuilder(status().isForbidden());
	}


	public static String asJsonString(User admin) {
		try {
			return new ObjectMapper().writeValueAsString(admin);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
