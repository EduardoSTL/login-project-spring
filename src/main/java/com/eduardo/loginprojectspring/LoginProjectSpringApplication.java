package com.eduardo.loginprojectspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.eduardo.loginprojectspring")
public class LoginProjectSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginProjectSpringApplication.class, args);
	}
}
