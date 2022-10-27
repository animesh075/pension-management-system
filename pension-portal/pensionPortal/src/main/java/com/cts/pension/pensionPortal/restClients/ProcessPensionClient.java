package com.cts.pension.pensionPortal.restClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.pension.pensionPortal.model.PensionDetail;
import com.cts.pension.pensionPortal.model.Pensioner;
import com.cts.pension.pensionPortal.model.PensionerInput;

//@FeignClient(name = "ProcessPensionService", url="http://35.170.80.239:8063")
@FeignClient(name = "ProcessPensionService", url="${PROCESS_VAR:http://localhost:8063}")
public interface ProcessPensionClient {

	@PostMapping("/api/process/pensionerInput")
	public PensionDetail getPensionDetail(@RequestHeader(name = "Authorization") String token, @RequestBody PensionerInput pensionerInput);

	@GetMapping("/api/process/details")
	public List<Pensioner> allDetail();
}
