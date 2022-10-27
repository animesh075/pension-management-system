package com.cts.pension.processPension.restClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.pension.processPension.model.ProcessPensionInput;

@FeignClient(name = "pensionDisbursementService", url = "${DISBURSE_VAR:http://localhost:8062}")
public interface PensionDisbursementClient {
	
	@PostMapping("/api/disbursement/disbursePension")
	public int getPensionDisbursement(@RequestHeader(name = "Authorization") String token,
			@RequestBody ProcessPensionInput processPensionInput);



}
