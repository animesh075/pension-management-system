package com.cts.pension.pensionerDetail.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.pension.pensionerDetail.exception.ResourceNotFoundException;
import com.cts.pension.pensionerDetail.model.PensionerDetails;
import com.cts.pension.pensionerDetail.repository.PensionerDetailsRepository;
import com.cts.pension.pensionerDetail.restClient.AuthorizationClient;
import com.cts.pension.pensionerDetail.service.PensionDetailsServiceImpl;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/details")
public class PensionerDetailsController {
	private static final Logger logger = LoggerFactory.getLogger(PensionerDetailsController.class);

	@Autowired
	private AuthorizationClient authorizationClient;
	
	@Autowired
	private PensionerDetailsRepository pensionerDetailsRepository;
	
	@Autowired
	private PensionDetailsServiceImpl pensionDetailsServiceImpl;
	
	// all pensioner details

	@GetMapping("/allDetails")
	public List<PensionerDetails> getAllDetail() {
		logger.info("STARTED - getAllDetail");
		logger.info("END - getAllDetail");
		return pensionerDetailsRepository.findAll();

	}

	// GET Pensioner Detail by ID

	@GetMapping("/pensionerList/{aadharNumber}")
	@JsonDeserialize(as = Boolean.class)
	public PensionerDetails getPensionerById(@RequestHeader("Authorization") String token,
			@PathVariable(value = "aadharNumber") String aadharNumber) throws Exception {
		if(authorizationClient.getValidity(token)!=null) {
			PensionerDetails pensioner = 
					pensionDetailsServiceImpl.getPensionerDetailByAadhaarNumber(aadharNumber);
			return pensioner;
		} else {
			logger.info("Exception");
			throw new Exception("Token is not valid");
		}
	}

	// Update Pensioner Detail rest API

//	@PutMapping("/pensionerList/{aadharNumber}")
//	public ResponseEntity<PensionerDetails> update(@RequestHeader("Authorization") String token,
//			@PathVariable(value = "aadharNumber") String aadharNumber, @RequestBody PensionerDetails pensionerDetails) {
//
//		PensionerDetails pensioner = pensionerDetailsRepository.findById(aadharNumber)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee Doesn't exist with id :" + aadharNumber));
//
//		pensioner.setAadharNumber(pensionerDetails.getAadharNumber());
//		pensioner.setName(pensionerDetails.getName());
//		pensioner.setDateOfBirth(pensionerDetails.getDateOfBirth());
//		pensioner.setPanNumber(pensionerDetails.getName());
//		pensioner.setSalary(pensionerDetails.getSalary());
//		pensioner.setAllowances(pensionerDetails.getAllowances());
//		pensioner.setPensionType(pensionerDetails.getPensionType());
//
//		PensionerDetails updatedEmployee = pensionerDetailsRepository.save(pensioner);
//		return ResponseEntity.ok(updatedEmployee);
//	}

	// Delete Pensioner Detail by ID

	@DeleteMapping("/pensionerList/{aadharNumber}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "aadharNumber") String aadharNumber)
			throws ResourceNotFoundException {
		PensionerDetails pensioner = pensionerDetailsRepository.findById(aadharNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Pensioner with aadhaar number not found"));

		pensionerDetailsRepository.delete(pensioner);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
