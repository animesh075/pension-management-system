package com.cts.pension.pensionerDetail.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.pension.pensionerDetail.model.BankDetail;
import com.cts.pension.pensionerDetail.model.PensionerDetails;

@SpringBootTest(classes = PensionerDetailsServiceTest.class)
@AutoConfigureMockMvc
public class PensionerDetailsServiceTest {

	@InjectMocks
	private PensionDetailsServiceImpl pds;
	
	@Test
	public void testNotNullPensionDetailServiceObject() {
		assertNotNull(pds);
	}
	
	@Test
	public void testPensionerDetailFunction() {
		BankDetail bankDetail = new BankDetail("ICICI", "12345678", "private");
		PensionerDetails pensionerDetail = new PensionerDetails("123456789012", "Pratyush", "06-11-1999", "PASW33334DW",
				27000.0, 10000.0, "family", bankDetail);
		assertNotNull(pensionerDetail);
		assertNotNull(bankDetail);
	}
}
