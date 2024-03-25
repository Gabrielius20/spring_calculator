package com.spring.calculator;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index(Model model) {
        // If Model "number" doesn't pass validation from it, we return the view
        model.addAttribute("number", new Number());
        // Return the jsp file must be in webapp -> WEB-INF -> jsp
        return "calculator";
    }


    // Because the calculator form uses POST method we need to use POST here as well

    /*@RequestMapping(method = RequestMethod.POST, value = "/calculate")*/
    @PostMapping("/calculate")
    // You can do it with @RequestParam
    public String calculate(@Valid @ModelAttribute("number") Number e, BindingResult bindingResult, @RequestParam HashMap<String, String> numbers, ModelMap modelMap) {
        int num1 = Integer.parseInt(numbers.get("num1"));
        int num2 = Integer.parseInt(numbers.get("num2"));
        String symbol = numbers.get("symbol");
        System.out.println(numbers.entrySet());

        if (bindingResult.hasErrors()) {
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
                        modelMap.put("divisionError", "Can't divide by zero");
                        // Prefix + file name + suffix
                        return "calculator";
                    }
                }
                default -> {
                    return "calculator";
                }
            }
            modelMap.put("num1", num1);
            modelMap.put("num2", num2);
            modelMap.put("symbol", symbol);
            modelMap.put("result", result);
        }
        return "calculate";
    }

}
