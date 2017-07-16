package com.warthur.spring.ioc.dao.impl;


import com.warthur.spring.ioc.dao.UserDAO;
import com.warthur.spring.ioc.model.User;
import org.springframework.stereotype.Component;

/**
 * Created by warthur on 17/7/8.
 */
@Component("userDao")
public class UserDAOImpl implements UserDAO {

    public void saveUser(User user) {
        System.out.println("saveUser Info: " + user.getUserName() + " " + user.getPassword());
    }
}
