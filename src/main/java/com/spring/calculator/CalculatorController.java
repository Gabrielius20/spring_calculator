package com.spring.calculator;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


// Web Controller that lets use @RequestMapping
// It combines what the user inputs with our available resources
// @RestController annotation lets for example: String type result needs to be printed exactly as is.
@RestController

// Defines the configuration component. Inside lets create bean from methods with @Beans annotation.
// This class level annotation lets Spring "guess"" the configuration
// Based on dependencies (.jar library's) witch the programmer puts in the project (pom.xml)
// In this case it works together with the main method

@EnableAutoConfiguration
public class CalculatorController {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String hello  () {
        return "Internet calculator<p>"
                + "Operations: <br>"
                + "&nbsp;&nbsp; " + "Add<br>"
                + "&nbsp;&nbsp; " + "Subtract<br>"
                + "&nbsp;&nbsp; " + "Multiply<br>"
                + "&nbsp;&nbsp; " + "Divide<br>";
    }
}
