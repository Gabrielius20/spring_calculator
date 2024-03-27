package com.spring.calculator.config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    // Persistence unit yra konfigūracija, kuri sujungia objektus ir su jais susijusius parametrus,
    // leidžiančius tvarkyti ir išlaikyti duomenis duomenų bazėje.
    // Persistence unit yra apibrėžiamas persistence.xml faile, esančiame META-INF kataloge.
    // Šiame faile nurodoma kaip objektai yra valdomi ir saugomi duomenų bazėje
    private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
    // EntityManagerFactory yra atsakingas už EntityManager egzempliorių (instanciju) sukūrimą,
    // naudojamų sąveikai su duomenų baze, kūrimą ir tvarkymą
    private static EntityManagerFactory factory;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }

    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }
}
