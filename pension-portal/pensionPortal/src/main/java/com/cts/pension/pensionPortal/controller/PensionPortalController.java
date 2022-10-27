package com.cts.pension.pensionPortal.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.pension.pensionPortal.exception.ResourceNotFoundException;
import com.cts.pension.pensionPortal.model.PensionDetail;
import com.cts.pension.pensionPortal.model.Pensioner;
import com.cts.pension.pensionPortal.model.PensionerInput;
import com.cts.pension.pensionPortal.model.ProcessPensionInput;
import com.cts.pension.pensionPortal.model.ProcessPensionResponse;
import com.cts.pension.pensionPortal.restClients.AuthClient;
import com.cts.pension.pensionPortal.restClients.PensionDisbursementClient;
import com.cts.pension.pensionPortal.restClients.ProcessPensionClient;
//import com.cts.pension.pensionPortal.services.PensionPortalServiceImpl;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/portal")
public class PensionPortalController {
	
	private static Logger logger = LoggerFactory.getLogger(PensionPortalController.class);

	private AuthClient authClient;
	private ProcessPensionClient processPensionClient;
	private PensionDisbursementClient pensionDisbursementClient;
	
	@Autowired
	public PensionPortalController(AuthClient authClient, ProcessPensionClient processPensionClient,
			PensionDisbursementClient pensionDisbursementClient) {
		this.authClient = authClient;
		this.processPensionClient = processPensionClient;
		this.pensionDisbursementClient = pensionDisbursementClient;
	}

	
//	@GetMapping("/details")
//	public List<Pensioner> allDetail() {
//		logger.info("STARTED - allDetail");
//		List<Pensioner> pensionerDetail = null;
//		try {
//			pensionerDetail = processPensionClient.allDetail();
//		} catch (Exception e) {
//			throw new ResourceNotFoundException("pensioner detail list not found");
//		}
//		logger.info("END - allDetail");
//		return pensionerDetail;
//
//	}
	
	@PostMapping("/pensionDetail")
	@JsonDeserialize(as = Boolean.class)
	public ResponseEntity<PensionDetail> getPensionDetail(@RequestHeader(name = "Authorization") String token,
			@RequestBody PensionerInput pensionerInput) {
		logger.info("STARTED - getPensionDetail");
		
			if(authClient.getValidity(token)!=null) {
				PensionDetail pensionDetail = processPensionClient.getPensionDetail(token, pensionerInput);
				logger.info("END - getPensionDetail");
				return ResponseEntity.ok(pensionDetail);
			}else {
				logger.error("EXCEPTION - getPensionDetail");
				throw new ResourceNotFoundException("Enter a VALID TOKEN");
			}
//		} catch (Exception e) {
//			logger.error("EXCEPTION - getPensionDetail");
//			throw new ResourceNotFoundException();
//		}
//		PensionDetail pensionDetail = processPensionClient.getPensionDetail(token, pensionerInput);
//		logger.info("END - getPensionDetail");
//		return ResponseEntity.ok(pensionDetail);
	}
	
	@PostMapping("/processPension")
	public ProcessPensionResponse getStatusCode(@RequestHeader(name = "Authorization") String token,
			@RequestBody ProcessPensionInput processPensionInput) {
		logger.info("STARTED - getStatusCode");
		try {
			authClient.getValidity(token);
		} catch (Exception e) {
			logger.error("EXCEPTION - getStatusCode");
			throw new ResourceNotFoundException("enter a valid token");
		}
//		logger.info("END - getStatusCode");
		return pensionDisbursementClient.getPensionDisbursement(token, processPensionInput);
	}
}
