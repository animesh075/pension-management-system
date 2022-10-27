package com.cts.pension.processPension.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.pension.processPension.model.BankDetail;
import com.cts.pension.processPension.model.PensionDetail;
import com.cts.pension.processPension.model.Pensioner;
import com.cts.pension.processPension.model.PensionerInput;
import com.cts.pension.processPension.services.ProcessPensionService;

@SpringBootTest(classes = ProcessPensionServiceTest.class)
@AutoConfigureMockMvc
public class ProcessPensionServiceTest {

	@InjectMocks
	private ProcessPensionService pps;

	@Test
	public void testNotNullPensionProcessServiceObject() {
		assertNotNull(pps);
	}

	@Test
	public void TestProcessPensionDetailFunction() {

	}

//	@Test
//	public void getPensionDetailPrivateSuccess() {
//		BankDetail bankDetail = new BankDetail("ICICI", "33056578", "private");
//		Pensioner pensioner = new Pensioner("791536459012", "ItachiUchiha", "29-09-1999", "KCASD1234Q", 27000.0,
//				10000.0, "self", bankDetail);
////		PensionerInput pensionerInput = new PensionerInput("ItachiUchiha","29-09-1999","KCASD1234Q","791536459012","self");
//
//		PensionDetail pensionDetail = new PensionDetail(pensioner.getName(), pensioner.getDateOfBirth(),
//				pensioner.getPanNumber(), pensioner.getPensionType(), 31050.0);
//
//		assertNotNull(pensionDetail);
//
//	}
	@Test
	public void getPensionDetailSelfPrivateSuccess() {
		BankDetail bankDetail = new BankDetail("ICICI", "33056578", "private");
		Pensioner pensioner = new Pensioner("791536459012", "ItachiUchiha", "29-09-1999", "KCASD1234Q", 27000.0,
				10000.0, "self", bankDetail);
		PensionerInput pensionerInput = new PensionerInput("ItachiUchiha","29-09-1999","KCASD1234Q","791536459012","self");
		assertNotNull(pps.getPensionDetail(pensioner, pensionerInput));
	}
	
	@Test
	public void calculatePensionFamilyPublicSuccess() {
		BankDetail bankDetail = new BankDetail("SBI", "33056579", "public");
		Pensioner pensioner = new Pensioner("791536459013", "NarutoUzumaki", "27-10-1998", "PCQKL1285Q", 30000.0,
				12000.0, "family", bankDetail);
		PensionerInput pensionerInput = new PensionerInput( "NarutoUzumaki", "27-10-1998", "PCQKL1285Q","791536459012","family");
		assertNotNull(pps.getPensionDetail(pensioner, pensionerInput));

}
	
	@Test
	public void savePensionDetailSuccess() {
		PensionDetail pensionDetail = new PensionDetail( "NarutoUzumaki", "27-10-1998","PCQKL1285Q","family",26500.0);
//		PensionDetail action = pps.savePensionDetail(pensionDetail);
//		assertNotNull(pps.savePensionDetail(pensionDetail));
		
	}

}
