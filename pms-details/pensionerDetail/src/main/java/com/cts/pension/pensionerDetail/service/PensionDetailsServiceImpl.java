package com.cts.pension.pensionerDetail.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.pension.pensionerDetail.exception.ResourceNotFoundException;
import com.cts.pension.pensionerDetail.model.BankDetail;
import com.cts.pension.pensionerDetail.model.PensionerDetails;
import com.cts.pension.pensionerDetail.repository.PensionerDetailsRepository;

@Service
public class PensionDetailsServiceImpl {

	private static final Logger logger = LoggerFactory.getLogger(PensionDetailsServiceImpl.class);
	private PensionerDetailsRepository pensionerDetailsRepository;

	@Autowired
	public PensionDetailsServiceImpl(PensionerDetailsRepository pensionerDetailsRepository) {
		this.pensionerDetailsRepository = pensionerDetailsRepository;
	}
  String line = "";
  BufferedReader br = new BufferedReader(
          new InputStreamReader(this.getClass().getResourceAsStream("/details.csv")));
	@PostConstruct
	public void savePensionerData() {
		logger.info("Started");
		List<PensionerDetails> pensionerDetailsList = new ArrayList<>();
		try {
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				PensionerDetails pensionerDetails = new PensionerDetails();
				pensionerDetails.setAadharNumber(data[0]);
				pensionerDetails.setName(data[1]);
				pensionerDetails.setDateOfBirth(data[2]);
				pensionerDetails.setPanNumber(data[3]);
				pensionerDetails.setSalary(Double.parseDouble(data[4]));
				pensionerDetails.setAllowances(Double.parseDouble(data[5]));
				pensionerDetails.setPensionType(data[6]);
				pensionerDetails.setBankDetail(new BankDetail(data[7], data[8], data[9]));

				pensionerDetailsList.add(pensionerDetails);

			}
		} catch (Exception e) {
			logger.error("EXCEPTION - savePensionerData");
			throw new ResourceNotFoundException("pensioner detail not added");
		}

		pensionerDetailsRepository.saveAll(pensionerDetailsList);
		logger.info("END - savePensionData");

	}
	
	public PensionerDetails getPensionerDetailByAadhaarNumber(String aadharNumber) {
		
		PensionerDetails pensioner = pensionerDetailsRepository.findById(aadharNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Pensioner with aadhaar number not found"));
		
		return pensioner;

	}

}