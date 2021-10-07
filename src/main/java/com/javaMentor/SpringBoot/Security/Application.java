package com.javaMentor.SpringBoot.Security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

//@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.SecurityConfig.class)

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
