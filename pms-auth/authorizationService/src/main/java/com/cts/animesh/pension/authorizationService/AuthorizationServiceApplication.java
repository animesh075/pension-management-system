package com.cts.animesh.pension.authorizationService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cts.animesh.pension.authorizationService.model.User;
import com.cts.animesh.pension.authorizationService.repository.UserRepository;

@SpringBootApplication
public class AuthorizationServiceApplication {

	private UserRepository userRepository;

	@Autowired
	public AuthorizationServiceApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostConstruct
	public void initUser() {
		List<User> users = Stream.of(new User("1", "abc", "animesh", ""), new User("2", "123", "ankush", ""))
				.collect(Collectors.toList());
		userRepository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(AuthorizationServiceApplication.class, args);
	}

}
