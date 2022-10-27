package com.cts.animesh.pension.authorizationService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.animesh.pension.authorizationService.model.AuthResponse;
import com.cts.animesh.pension.authorizationService.model.User;
import com.cts.animesh.pension.authorizationService.service.AdminUserService;
import com.cts.animesh.pension.authorizationService.service.JwtUtil;



@CrossOrigin(origins = "*")
@RestController
//@RequestMapping("/auth")
public class AuthenticateController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthenticateController.class);
	
	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AdminUserService adminUserDetailService;
	
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> login(@RequestBody User userlogincredentials) throws Exception {
		logger.info("STARTED - generateToken");
		final UserDetails userDetails =adminUserDetailService.loadUserByUsername(userlogincredentials.getId());
		String uid= "";
		String uname= "";
		String upassword= "";
		String generateToken = "";
		if((userDetails.getPassword().equals(userlogincredentials.getPassword())) 
				) {
			uid =userlogincredentials.getId();
			uname=userlogincredentials.getUsername();
			upassword  =userlogincredentials.getPassword();
			generateToken = jwtUtil.generateToken(userDetails);
			logger.info(generateToken);
			logger.info("END");
			return new ResponseEntity<>(new User(uid,upassword,uname,generateToken),HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Not Accesible",HttpStatus.FORBIDDEN);
		}

	}

	// Authorize the data and display data
	
	@GetMapping("/authorize")
	public ResponseEntity<?> getValidity(@RequestHeader("Authorization") String token) {

		logger.info("STARTED - authorization");
		AuthResponse res = new AuthResponse();
		String token1 = token.substring(7);
		if(token1 == null) {
			res.setValid(false);
			return new ResponseEntity<>(res,HttpStatus.FORBIDDEN);
		}else {
			
			UserDetails user = adminUserDetailService.loadUserByUsername(jwtUtil.extractUsername(token1));
			if(jwtUtil.validateToken(token1,user)) {
				
				res.setUid(jwtUtil.extractUsername(token1));
				res.setValid(true);
				res.setName("Admin");
				return new ResponseEntity<>(res,HttpStatus.OK);
				
			}else {
				res.setValid(false);
				return new ResponseEntity<>(res,HttpStatus.FORBIDDEN);
			}
		}

	}

}
