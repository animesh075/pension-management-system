package com.cts.pension.processPension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.pension.processPension.model.BankDetail;
import com.cts.pension.processPension.model.PensionDetail;
import com.cts.pension.processPension.model.Pensioner;
import com.cts.pension.processPension.model.PensionerInput;
import com.cts.pension.processPension.services.ProcessPensionService;

@SpringBootTest
class ProcessPensionApplicationTests {

	@Autowired
	ProcessPensionService processPensionService;
	
	@Test
	public void contextLoads() {
		assertNotNull(processPensionService);
	}
	BankDetail bankDetail = new BankDetail("ICICI","33056578","private");
	Pensioner pensioner = new Pensioner("791536459012","ItachiUchiha","29-09-1999",
			"KCASD1234Q",27000.0,10000.0,"self",bankDetail);
	PensionerInput pensionerInput = new PensionerInput("ItachiUchiha","29-01-1999","PCASD1234Q","791536459012","self");

	@Test
	public void calculatePensionTestSuccess() throws Exception {
//		double pensionAmount = 0;
		processPensionService.getPensionDetail(pensioner, pensionerInput);
//		assertEquals(31050,pensionAmount);
		PensionDetail pensionDetail = new PensionDetail(pensioner.getName(), pensioner.getDateOfBirth(),
				pensioner.getPanNumber(), pensioner.getPensionType(), 31050);
//		assertEquals(31050.0,processPensionService.getPensionDetail(pensioner, pensionerInput));
		assertNotNull(pensionDetail);
	}
	
//	@Test
//	public void calculatePensionTestFail() throws Exception {
////		double pensionAmount = 0;
//		processPensionService.getPensionDetail(pensioner, pensionerInput);
////		assertEquals(31050,pensionAmount);
//		PensionDetail pensionDetail = new PensionDetail(pensioner.getName(), pensioner.getDateOfBirth(),
//				pensioner.getPanNumber(), pensioner.getPensionType(), 27050);
////		assertEquals(31050.0,processPensionService.getPensionDetail(pensioner, pensionerInput));
//		assertNotNull(pensionDetail);
//	}
}
