package com.cts.pension.pensionDisbursement.services;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.pension.pensionDisbursement.model.BankDetail;
import com.cts.pension.pensionDisbursement.model.Pensioner;
import com.cts.pension.pensionDisbursement.model.ProcessPensionInput;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DisbursementSeviceTests {
	ProcessPensionInput processPensionInput = new ProcessPensionInput("791536459012", 31050.0, 550.0);
	ProcessPensionInput processPensionInput1 = new ProcessPensionInput("791536459012", 26500.0, 500);
//	ProcessPensionInput processPensionInput2 = new ProcessPensionInput("1234567891014", 35451.8, 550);
//	ProcessPensionInput processPensionInput3 = new ProcessPensionInput("1234567891015", 31502.0, 500);
//	ProcessPensionInput processPensionInput4 = new ProcessPensionInput("1234567891016", 47450.0, 550);
//	ProcessPensionInput processPensionInput5 = new ProcessPensionInput("1234567891017", 49450.0, 550);
//	ProcessPensionInput processPensionInput6 = new ProcessPensionInput("1234567891018", 88500.0, 500);

	@Autowired
	private PensionDisbursementService pensionDisbursementService;

	@Test
	public void contextLoads() {
		assertNotNull(pensionDisbursementService);
	}
	@Test
	public void statusCodeSuccess() {
		BankDetail bankDetail = new BankDetail("ICICI", "33056578", "private");

		Pensioner pensioner = new Pensioner("791536459012", "ItachiUchiha", "29-09-1999", "KCASD1234Q", 27000.0,
				10000.0, "self", bankDetail);
		assertNotNull(pensionDisbursementService.statusCode(pensioner, processPensionInput));
	}
	
	@Test
	public void statusCodeFail() {
		BankDetail bankDetail = new BankDetail("ICICI", "33056578", "private");

		Pensioner pensioner = new Pensioner("791536459012", "ItachiUchiha", "29-09-1999", "KCASD1234Q", 27000.0,
				10000.0, "self", bankDetail);
		assertNotNull(pensionDisbursementService.statusCode(pensioner, processPensionInput1));
	}



	@Test
	public void calculatePensionSelfPrivateSuccess() {
		BankDetail bankDetail = new BankDetail("ICICI", "33056578", "private");
		Pensioner pensioner = new Pensioner("791536459012", "ItachiUchiha", "29-09-1999", "KCASD1234Q", 27000.0,
				10000.0, "self", bankDetail);

		assertTrue(pensionDisbursementService.calculatePension(pensioner, 31050.0, "private", 550.0));

}
	
	@Test
	public void calculatePensionFamilyPublicSuccess() {
		BankDetail bankDetail = new BankDetail("SBI", "33056579", "public");
		Pensioner pensioner = new Pensioner("791536459013", "NarutoUzumaki", "27-10-1998", "PCQKL1285Q", 30000.0,
				12000.0, "family", bankDetail);

		assertTrue(pensionDisbursementService.calculatePension(pensioner, 26500.0, "public", 500.0));

}

	@Test
	public void calculatePensionSelfPrivateFail() {
		BankDetail bankDetail = new BankDetail("ICICI", "33056578", "private");
		Pensioner pensioner = new Pensioner("791536459012", "ItachiUchiha", "29-09-1999", "KCASD1234Q", 27000.0,
				10000.0, "self", bankDetail);

		assertFalse(pensionDisbursementService.calculatePension(pensioner, 31050.0, "private", 500.0));

}
	
	@Test
	public void calculatePensionFamilyPublicFail() {
		BankDetail bankDetail = new BankDetail("SBI", "33056579", "public");
		Pensioner pensioner = new Pensioner("791536459013", "NarutoUzumaki", "27-10-1998", "PCQKL1285Q", 30000.0,
				12000.0, "family", bankDetail);

		assertFalse(pensionDisbursementService.calculatePension(pensioner, 26500.0, "public", 550.0));

}

}
