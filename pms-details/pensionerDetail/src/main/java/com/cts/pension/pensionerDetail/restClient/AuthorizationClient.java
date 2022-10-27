package com.cts.pension.pensionerDetail.restClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

//@FeignClient(name="authorizationService" , url = "http://animesh-pms-microservices-lb-34587307.us-east-1.elb.amazonaws.com")
@FeignClient(name="authorizationService" , url = "${AUTH_VAR:http://localhost:8060}")
public interface AuthorizationClient {

	@GetMapping("/api/auth/authorize")
	public ResponseEntity<?> getValidity(@RequestHeader("Authorization") String token1);

}
