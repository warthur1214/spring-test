package com.warthur.spring.hibernate.dao.Impl;

import com.warthur.spring.hibernate.dao.UserMapper;
import com.warthur.spring.hibernate.pojo.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by warthur on 17/7/15.
 */
@Repository
public class UserMapperImpl implements UserMapper {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    // @Autowired
    // private SessionFactory sessionFactory;

    public void addUser(User user) {

        // Session session = sessionFactory.getCurrentSession();
        // session.save(user);
        System.out.println("addUser: " + user.getClass());
        hibernateTemplate.save(user);

    }

    public void deleteUser(User user) {

        System.out.println("deleteUser: " + user.getClass());
        hibernateTemplate.delete(user);
        hibernateTemplate.flush();
    }

}
