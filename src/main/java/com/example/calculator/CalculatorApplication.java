package com.example.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @SpringBootApplication anotacija yral ygi @Configuration, @EnableAutoConfiguration ir @ComponentScan
// Nurodoma klaseje, turincioje pagrindini (main) metoda.
@SpringBootApplication
// Web kontroleris (controller), pazymi MVC valdikli. Leidzia viduje naudoti @RequestMapping
// @RestController anotacija nurodo, jog String tipo rezultatas turetu buti isspausdinamas klientui toks koks yra.
@RestController
public class CalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
		System.out.println("Hello, Spring boot");
	}
//	@GetMapping("/hello")
//	public String hello(@RequestParam(value = "name", defaultValue = "World of Spring boot") String name) {
//		return String.format("Hello %s!", name);
//	}
}
