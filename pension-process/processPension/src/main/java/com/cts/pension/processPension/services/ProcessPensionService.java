package com.cts.pension.processPension.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.pension.processPension.model.PensionDetail;
import com.cts.pension.processPension.model.Pensioner;
import com.cts.pension.processPension.model.PensionerInput;
import com.cts.pension.processPension.model.ProcessPensionResponse;
import com.cts.pension.processPension.repository.ProcessPensionRepository;


@Service
public class ProcessPensionService {

	private static Logger logger = LoggerFactory.getLogger(ProcessPensionService.class);

	@Autowired
	private ProcessPensionRepository processPensionRepository;
	
	@Autowired
	public ProcessPensionService(ProcessPensionRepository processPensionRepository) {
		this.processPensionRepository = processPensionRepository;
	}
	
	public PensionDetail getPensionDetail(Pensioner pensioner, PensionerInput pensionerInput) {
		logger.info("STARTED - getPensionDetail");
		double pensionAmount = 0;

		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse();

		if (pensioner.getPensionType().equalsIgnoreCase("self")) {
			pensionAmount = (0.8 * pensioner.getSalary() + pensioner.getAllowances());
		} else if (pensioner.getPensionType().equalsIgnoreCase("family")) {
			pensionAmount = (0.5 * pensioner.getSalary() + pensioner.getAllowances());
		}

		if (pensioner.getBankDetail().getBankType().equalsIgnoreCase("private")) {
			pensionAmount = pensionAmount - 550;

			processPensionResponse.setProcessPensionStatusCode(10);

		} else if (pensioner.getBankDetail().getBankType().equalsIgnoreCase("public")) {
			pensionAmount = pensionAmount - 500;
			processPensionResponse.setProcessPensionStatusCode(10);

		}
		PensionDetail pensionDetail = new PensionDetail(pensioner.getName(), pensioner.getDateOfBirth(),
				pensioner.getPanNumber(), pensioner.getPensionType(), pensionAmount);

		logger.info("END - getPensionDetail");
		return pensionDetail;

	}

	public PensionDetail savePensionDetail(PensionDetail pensionDetail) {
		logger.info("STARTED - savePensionDetail");
		logger.info("END - savePensionDetail");
		return processPensionRepository.save(pensionDetail);

	}

}
