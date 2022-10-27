package com.cts.pension.processPension.restClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.pension.processPension.model.Pensioner;

//@FeignClient(name="pensionerDetailsService", url = "${ENV_VARIABLE:http://localhost:8061}")
//@FeignClient(name="pensionerDetailsService",url = "http://3.238.2.194:8061")
@FeignClient(name="pensionerDetailsService" , url = "${DETAILS_VAR:http://localhost:8061}")
public interface PensionerDetailsClient {
	
	@GetMapping("/api/details/pensionerList/{aadharNumber}")
	public Pensioner getPensionerById(@RequestHeader("Authorization") String token, @PathVariable String aadharNumber);

	@GetMapping("/api/details/allDetails")
	public List<Pensioner> getAllDetail();
}
