package com.cts.animesh.pension.authorizationService.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.animesh.pension.authorizationService.model.User;
import com.cts.animesh.pension.authorizationService.repository.UserRepository;

@Service
public class AdminUserService implements UserDetailsService {

	private static Logger logger = LoggerFactory.getLogger(AdminUserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String uid){
		logger.info("STARTS");
		try {
			User user = userRepository.findById(uid).orElse(null);
			if(user != null) {
				user.getUsername();
				logger.info("END - User found");
				return new org.springframework.security.core.userdetails.User(user.getId(),user.getPassword(),new ArrayList<>());
			}else {
				logger.info("END");
				throw new UsernameNotFoundException("Username Not Found Exception");
				
			}
		} catch (Exception e) {
			logger.info("ERROR - username not found");
			throw new UsernameNotFoundException("Username Not Found Exception");
		}
	}
}
