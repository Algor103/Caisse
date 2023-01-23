package com.example.caisse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAutoConfiguration
@RestController
public class CaisseApplication {

	@RequestMapping("/")
	String home() {
		return "hello world";
	}

	public static void main(String[] args) {
		SpringApplication.run(CaisseApplication.class, args);
	}

}
