package com.spring.calculator.model;

import com.spring.calculator.config.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class NumberDAOImpl implements NumberDAO {
    public void insertEntity(Number number) {
        // EntityManager suteikia metodus objektams kurti, skaityti, trynti ir atnaujinti, bei leidžia pateikti užklausas duomenų bazėms.
        // EntityManager nėra apsaugota nuo gijų, tai reiškia, kad kiekviena gija turi naudoti savo „EntityManager“ instanciją.
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(number);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Number findEntityById(int id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Number numbers = entityManager.createQuery("SELECT n FROM Number n WHERE n.id = :id", Number.class)
                .setParameter("id", id)
                .getSingleResult();

        entityManager.getTransaction().commit();
        entityManager.close();

        return numbers;
    }

    public List<Number> findEntities() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        List<Number> numbers = entityManager.createQuery("SELECT n FROM Number n", Number.class)
                .getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return numbers;
    }

    public void updateEntity(Number number) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Number number1 = entityManager.find(Number.class, number.getId());
        number1.setNum1(number.getNum1());
        number1.setNum2(number.getNum2());
        number1.setOperation(number.getOperation());
        number1.setResult(number.getResult());

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeEntityById(int id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Number number = entityManager.find(Number.class, id);
        entityManager.remove(number);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
