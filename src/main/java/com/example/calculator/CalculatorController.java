package com.example.calculator;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
// Zymi konfiguracijos komponenta viduje leidzia kurti bean per metodus su @Bean anotacija.
// Si klases lygio anotacija nurodo Sping karkasui "Atspeti" konfiguracija
// remiantis priklausomybemis (jar bibliotekomis) kurias programuotojas itraukia i projekta (pom.xml)
// siuo atveju ji veikia kartu su main metodu.
@EnableAutoConfiguration
public class CalculatorController {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String hello() {
        // ApplicationContext yra interface skirtas suteikti informacija apie aplikacijos konfiguracija
        // siuo atveju naudojama konfiguracija paimama is beans.xml failo
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        // bean - klases objektas kuris atitinka Singleton sablona.
        HelloWorld bean = (HelloWorld) applicationContext.getBean("helloWorld");
        return bean.getHello();
//        return "Calculator <p>" +
//                "Possible operations: <br>" +
//                "&nbsp;&nbsp; addition <br>" +
//                "&nbsp;&nbsp; subtraction <br>" +
//                "&nbsp;&nbsp; division <br>" +
//                "&nbsp;&nbsp; multiplication <br></p>";
    }
}
