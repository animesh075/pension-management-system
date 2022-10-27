package com.cts.pension.pensionDisbursement.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.pension.pensionDisbursement.exception.ProcessPensionException;
import com.cts.pension.pensionDisbursement.model.ProcessPensionInput;
import com.cts.pension.pensionDisbursement.model.ProcessPensionResponse;
import com.cts.pension.pensionDisbursement.restClients.AuthClient;
import com.cts.pension.pensionDisbursement.restClients.PensionerDetailClient;
import com.cts.pension.pensionDisbursement.services.PensionDisbursementService;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST})
//@RequestMapping("/disbursement")
public class PensionDisbursementController {
	private static Logger logger = LoggerFactory.getLogger(PensionDisbursementController.class);

	@Autowired
	private AuthClient authClient;
	
	@Autowired
	private PensionerDetailClient pensionerDetailClient;
	
	@Autowired
	private PensionDisbursementService pensionDisbursementService;

	@Autowired
	public PensionDisbursementController(PensionerDetailClient pensionerDetailClient,
			PensionDisbursementService pensionDisbursementService) {

		this.pensionerDetailClient = pensionerDetailClient;
		this.pensionDisbursementService = pensionDisbursementService;
	}
	
	
	@PostMapping("/disbursePension")
	@JsonDeserialize(as = Boolean.class)
	public ProcessPensionResponse getPensionDisbursement(@RequestHeader("Authorization") String token,
			@RequestBody ProcessPensionInput processPensionInput) {
		logger.info("START");
		ProcessPensionResponse processPensionResponseCode = null;
		if (authClient.getValidity(token)!=null) {
			processPensionResponseCode = pensionDisbursementService.statusCode(
					pensionerDetailClient.getPensionerById(token, processPensionInput.getAadharNumber()),
					processPensionInput);
			logger.info("END");
			return processPensionResponseCode;
		}
		logger.info("END - Token invalid");

		return processPensionResponseCode;
	}


}
