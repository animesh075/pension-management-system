package com.cts.pension.pensionPortal.restClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.pension.pensionPortal.model.ProcessPensionInput;
import com.cts.pension.pensionPortal.model.ProcessPensionResponse;

//@FeignClient(name = "pensionDisbursementService", url = "http://44.193.12.65:8062")
@FeignClient(name = "pensionDisbursementService", url = "${DISBURSE_VAR:http://localhost:8062}")
public interface PensionDisbursementClient {
	
	@PostMapping("/api/disbursement/disbursePension")
	public ProcessPensionResponse getPensionDisbursement(@RequestHeader(name = "Authorization") String token,
			@RequestBody ProcessPensionInput processPensionInput);

	

}
