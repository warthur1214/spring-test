package com.warthur.spring.jpa.pojo;

import com.warthur.spring.jpa.common.util.EncryUtil;
import org.junit.Test;

import javax.persistence.*;

public class EmployeeTest {

    @Test
    public void save() {

        Employee employee = new Employee();
        employee.setName("warthur");
        employee.setPassword(EncryUtil.getMd5("123456"));
        employee.setTel("18516599223");

        String persistenceUnitName = "com.warthur.spring.jpa.pojo";
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(employee);
        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
