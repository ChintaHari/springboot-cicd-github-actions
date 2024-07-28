package com.example.springboot_cicd_github_actions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class SpringbootCicdGithubActionsApplication {

	@GetMapping("/message")
	public String getMessage() {
		return "Hello from Spring Boot! This project is using GitHub Actions for CI/CD.";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCicdGithubActionsApplication.class, args);
	}

}
