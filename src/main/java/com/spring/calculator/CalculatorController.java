package com.spring.calculator;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.HashMap;


// Web Controller that lets use @RequestMapping
// It combines what the user inputs with our available resources
// @RestController annotation lets for example: String type result needs to be printed exactly as is.
// However, we need to get a view, so we use @Controller

// Defines the configuration component. Inside lets create bean from methods with @Beans annotation.
// This class level annotation lets Spring "guess"" the configuration
// Based on dependencies (.jar library's) witch the programmer puts in the project (pom.xml)
// In this case it works together with the main method
@Controller
public class CalculatorController {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() {
        // Return the jsp file must be in webapp -> WEB-INF -> jsp
        return "calculator.jsp";
    }


    // Because the calculator form uses POST method we need to use POST here as well
    @RequestMapping(method = RequestMethod.POST, value = "/calculate")
    public String calculate(@RequestParam HashMap<String, String> numbers, ModelMap modelMap) {
        int num1 = Integer.parseInt(numbers.get("num1"));
        int num2 = Integer.parseInt(numbers.get("num2"));
        String symbol = numbers.get("symbol");
        int result = 0;

        // Perform calculation based on the selected symbol
        switch (symbol) {
            case "+" -> result = num1 + num2;
            case "-" -> result = num1 - num2;
            case "*" -> result = num1 * num2;
            case "/" -> {
                // Check if num2 is not zero to avoid division by zero
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    // Handle division by zero error
                    modelMap.put("error", "Can't divide by zero");
                    return "calculator.jsp";
                }
            }
            default -> {
                return "calculator.jsp";
            }
        }

        // Model map is used to send values from Spring MVC controller to JSP
        modelMap.put("num1", num1);
        modelMap.put("num2", num2);
        modelMap.put("symbol", symbol);
        modelMap.put("result", result);

        return "calculate.jsp";
    }

}
