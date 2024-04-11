package com.spring.calculator.config;

import com.spring.calculator.model.NumberDAO;
import com.spring.calculator.model.NumberDAOImpl;
import com.spring.calculator.service.NumberService;
import com.spring.calculator.service.NumberServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration - žymi konfiguracijos komponentą
// viduje leidžia kurti bean per metodus su @Bean
@Configuration
// Pradedami rasyti programa pradedam nuo visu visu bean apsirasymu.

public class SpringConfig {

    // Bean - tai objektai, kurie sudaro Spring aplikacijos pagrindą.
    // Paprastai tai Java klasė, realizuojanti tam tikrą interfeisą ir JavaBean specifikaciją.
    // Bean atitinka Singleton šabloną - programinės įrangos projektavimo schema,
    // kuri riboja klasės įvykdymą vienu "vieninteliu" egzemplioriumi.
    // Tai naudinga, kai reikia tiksliai vieno objekto, norint koordinuoti veiksmus visoje sistemoje.
    @Bean
    //@Qualifier anotacija kartu su @Autowired patikslina su kuriuo konkrečiai bean susieti priklausomybę.
    // Jeigu @Configuration klasėje yra daugiau negu vienas Bean, @Qualifier anotacija yra privaloma,
    // kitu atveju metama klaida:
    //"Consider making one of the beans as @Primary, updating the consumer to accept multiple beans,
    // or using @Qualifier to identify the bean that should be consumed"
    // Jeigu norim naudoti butent si bean tai turim naudoti qualifier ir controller claseje
    @Qualifier("NumberDAO")
    public NumberDAO getNumberDAO() {
        return new NumberDAOImpl();
    }

    @Bean
    @Qualifier("NumberService")
    public NumberService getNumberService() {
        return new NumberServiceImpl();
    }
}
