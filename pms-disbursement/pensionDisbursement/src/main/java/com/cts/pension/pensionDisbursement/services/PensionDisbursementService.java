package com.cts.pension.pensionDisbursement.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cts.pension.pensionDisbursement.model.Pensioner;
import com.cts.pension.pensionDisbursement.model.ProcessPensionInput;
import com.cts.pension.pensionDisbursement.model.ProcessPensionResponse;

import io.jsonwebtoken.Jwts;

@Service
public class PensionDisbursementService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PensionDisbursementService.class);
	private String secret_key = "${jwt.secret}";
	private int successCode = 10;
	private int failedCode = 21;
	
//	Processing the Pension
	
	public ProcessPensionResponse statusCode(Pensioner pensioner,ProcessPensionInput processPensionInput) {
		
		LOGGER.info("STARTED - statusCode");
		String bankType = pensioner.getBankDetail().getBankType();
		double bankServiceCharge = processPensionInput.getServiceCharge();
		
		if  (calculatePension(pensioner, processPensionInput.getPensionAmount(),bankType, bankServiceCharge)) {
			LOGGER.info("END - statusCode - sucess");
			return new ProcessPensionResponse(successCode);
		}
		LOGGER.info("END - statusCode - fail");
		return new ProcessPensionResponse(failedCode);
	}
	
	// Calculate Pension
	
		public boolean calculatePension(Pensioner pensioner, double pensionInput,String bankType, double bankCharge) {
		LOGGER.info("STARTED - calculatePension");
		double pensionAmount = 0;
		if (pensioner.getPensionType().equalsIgnoreCase("self")) {
			LOGGER.info(pensioner.getPensionType());
			pensionAmount = 0.8 * pensioner.getSalary() + pensioner.getAllowances();
		}
		
		else if (pensioner.getPensionType().equalsIgnoreCase("family")) {
			LOGGER.info(pensioner.getPensionType());
			pensionAmount = 0.5 * pensioner.getSalary() + pensioner.getAllowances();
		}
		
		//checking bank charge for private and public banks
		
		if (bankType.equalsIgnoreCase("private")) {
			if (bankCharge == 550) {
				LOGGER.info("END - inputBankCharge - private - true");
				pensionAmount = pensionAmount - 550;
				
			} else {
				LOGGER.info("END - inputBankCharge - private - false");
				
			}
		}
		if (bankType.equalsIgnoreCase("public")) {
			if (bankCharge == 500) {
				pensionAmount = pensionAmount - 500;
				LOGGER.info("END - inputBankCharge - public - true");
				
			} else {
				LOGGER.info("END - inputBankCharge - public - false");
				
			}
		}
		LOGGER.info(pensioner.getPensionType());
		LOGGER.info("END - calculatePension");
//		return pensionAmount == pensionInput;
		if(pensionAmount ==  pensionInput ) {
			LOGGER.info("True"+pensionAmount);
			LOGGER.info("True");
			
			return true;
		}else {
			LOGGER.info("False "+pensionAmount);
			return false;
		}
	}

	//checking bank charge for private and public banks
	

	public Boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(secret_key).parseClaimsJws(token).getBody();
			LOGGER.info("END");

			return true;
		} catch (Exception e) {
			LOGGER.info("EXCEPTION");
			return false;
		}
//    final String username = extractUsername(token);
//    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}
