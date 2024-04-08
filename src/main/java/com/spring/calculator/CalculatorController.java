package com.spring.calculator;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("number", new Number());
        // Return the jsp file must be in webapp -> WEB-INF -> jsp
        return "calculator";
    }


    // Because the calculator form uses POST method we need to use POST here as well

    /*@RequestMapping(method = RequestMethod.POST, value = "/calculate")*/
    @PostMapping("/calculate")
    // You can do it with @RequestParam
    // If you do validation the first parameter needs to be with @Valid and the second BindingResult
    // It must be in order
    // @Valid - created validation for this class object
    public String calculate(@Valid @ModelAttribute("number") Number e, BindingResult br,
                            @RequestParam HashMap<String, String> numbers, ModelMap modelMap) {

        int num1 = Integer.parseInt(numbers.get("num1"));
        int num2 = Integer.parseInt(numbers.get("num2"));
        String symbol = numbers.get("symbol");
        System.out.println(numbers.entrySet());

        // Or you can do it without if the values of frontend and backend are the same

        /*public String calculate(int num1, int num2, String symbol, ModelMap modelMap) {*/
        /*int num1 = Integer.parseInt(numbers.get("num1"));
        int num2 = Integer.parseInt(numbers.get("num2"));*/

        if (br.hasErrors()) {
            return "calculator";
        } else {
            int result = 0;

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
                        // Prefix + file name + suffix
                        return "calculator";
                    }
                }
                default -> {
                    return "calculator";
                }
            }

            // Model map is used to send values from Spring MVC controller to JSP
            modelMap.put("num1", num1);
            modelMap.put("num2", num2);
            modelMap.put("symbol", symbol);
            modelMap.put("result", result);

            return "calculate";
        }

    }

}
