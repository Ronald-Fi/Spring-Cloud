package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class StartSpringBootApplication {

	@RequestMapping("/")
	String index() {
		return "The first SpringBoot program";
	}

	public static void main(String[] args) {
		SpringApplication.run(StartSpringBootApplication.class, args);
	}

}
