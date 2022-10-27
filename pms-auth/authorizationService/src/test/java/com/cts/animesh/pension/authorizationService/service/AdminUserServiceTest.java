package com.cts.animesh.pension.authorizationService.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminUserServiceTest {
	
	@Autowired(required = true)
	AdminUserService adminUserService;

	@Test
	public void contextLoads() {

		assertNotNull(adminUserService);

	}
	
	@Test
	public void loadUserByUsernameTestSuccess() {

		assertEquals("1", adminUserService.loadUserByUsername("1").getUsername());
	}
	
//	@Test
//	public void loadUserByUsernameTestFail() {
//
//		assertFalse(false);
//	}

}
