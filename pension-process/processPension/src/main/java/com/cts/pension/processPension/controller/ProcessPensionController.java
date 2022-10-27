package com.cts.pension.processPension.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.pension.processPension.exception.ProcessPensionException;
import com.cts.pension.processPension.model.PensionDetail;
import com.cts.pension.processPension.model.Pensioner;
import com.cts.pension.processPension.model.PensionerInput;
import com.cts.pension.processPension.model.ProcessPensionInput;
import com.cts.pension.processPension.restClients.PensionDisbursementClient;
import com.cts.pension.processPension.restClients.PensionerDetailsClient;
import com.cts.pension.processPension.services.ProcessPensionService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
//@RequestMapping("/process")
public class ProcessPensionController {

	private static Logger logger = LoggerFactory.getLogger(ProcessPensionController.class);

	private PensionerDetailsClient pensionerDetailsClient;
	private ProcessPensionService processPensionService;
	private PensionDisbursementClient pensionDisbursementClient;

	@Autowired
	public ProcessPensionController(PensionerDetailsClient pensionerDetailsClient,
			PensionDisbursementClient pensionDisbursementClient, ProcessPensionService processPensionService) {
		this.pensionerDetailsClient = pensionerDetailsClient;
		this.pensionDisbursementClient = pensionDisbursementClient;
		this.processPensionService = processPensionService;
	}

	@GetMapping("/details")
	public List<Pensioner> allDetail() {
		logger.info("STARTED - allDetail");
		List<Pensioner> pensionerDetail = pensionerDetailsClient.getAllDetail();
		logger.info("END - allDetail");
		return pensionerDetail;
	}

	@PostMapping("/pensionerInput")
	public PensionDetail getPensionDetail(@RequestHeader(name = "Authorization") String token,
			@RequestBody PensionerInput pensionerInput) {
		logger.info("STARTED - pensionerInput");
		PensionDetail pensionDetail = null;
		try {
			logger.info(pensionerInput.getAadharNumber());
			pensionDetail = processPensionService.getPensionDetail(
					pensionerDetailsClient.getPensionerById(token, pensionerInput.getAadharNumber()), pensionerInput);

		} catch (Exception e) {
			logger.error("EXCEPTION - pensionerInput");
//			throw new ProcessPensionException("Pensioner Detail not correct");
		}
		logger.info("END - pensionerInput");
		return processPensionService.savePensionDetail(pensionDetail);

	}

	@PostMapping("/processPension")
	public int getStatusCode(@RequestHeader(name = "Authorization") String token,
			@RequestBody ProcessPensionInput processPensionInput) {
		logger.info("STARTED - getStatusCode");
		logger.info("END - getStatusCode");
		return pensionDisbursementClient.getPensionDisbursement(token, processPensionInput);
	}

}
