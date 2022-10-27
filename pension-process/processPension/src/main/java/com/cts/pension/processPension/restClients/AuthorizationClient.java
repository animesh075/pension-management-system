package com.cts.pension.processPension.restClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

//@FeignClient(name="authorizationService" , url = "${ENV_VARIABLE:http://localhost:8060}")
//@FeignClient(name="authorizationService",url="http://34.200.255.106:8060")
@FeignClient(name="authorizationService" , url = "${AUTH_VAR:http://localhost:8060}")
public interface AuthorizationClient {

	@GetMapping("/api/auth/authorize")
	public Boolean getValidity(@RequestHeader("Authorization") String token);
}
