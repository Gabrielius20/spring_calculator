package com.spring.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @SpringBootApplication anotacija yra lygi @Configuration, @EnableAutoConfiguration ir @ComponentScan
// Nurodoma klasėje, turinčioje pagrindinį (main) metodą.
@SpringBootApplication
// WEB Kontroleris. Pažymi MVC valdiklį. Leidžia viduje naudoti @RequestMapping
// @RestController anotacija nurodo, jog String tipo rezultatas turėtų būti išspausdinamas klientui toks koks yra.
@RestController

public class CalculatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);
        System.out.println("Woohoo pirmoji spring boot aplikacija");
    }

    // http://localhost:8080/hello?name=Andrius&surname=Nizevicius
    // Metodo pavadinimas klaustukas (?) raktas, lygybe, reiksme. Optional jeigu daugiau nori reiksmiu simbolis & (and)
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name2, Integer age) {
        return " Hello " + name2 + " metai: " + age;
    }

    @GetMapping("/index")
    public String index() {
        return "<h1>Internetinis skaiciuotuvas. Atliks operacijas: </h1><br>" +
                "&nbsp;&nbsp; sudeti <br>" +
                "&nbsp;&nbsp; dauginti <br>" +
                "&nbsp;&nbsp; dalinti <br>" +
                "&nbsp;&nbsp; atimti <br>";
    }
}

