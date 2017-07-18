package com.warthur.spring.hibernate.dao.Impl;

import com.warthur.spring.hibernate.dao.UserMapper;
import com.warthur.spring.hibernate.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by warthur on 17/7/15.
 */
@Repository
public class UserMapperImpl implements UserMapper {

    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(User user) {

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        System.out.println("addUser: " + user.getClass());

        // throw new RuntimeException("RuntimeException throwing!");
    }

    public void deleteUser(User user) {
        System.out.println("deleteUser: " + user.getClass());
    }

    public void close() {
        System.out.println("datasource close.....");
    }
}
