package com.spring.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



// Web controller lets to use RequestMapping
// @RestController tells that String type has to be printed exactly as it is
@RestController
// @SpringBootApplication annotation is equals to @Configuration, @EnableAutoConfiguration, @ComponentScan.
//This annotation is used in the class with the Main method
@SpringBootApplication
public class CalculatorApplication {

	//
	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
	}

	@GetMapping ("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "world") String name) {
		return String.format("Hello %s!", name);
	}



}
