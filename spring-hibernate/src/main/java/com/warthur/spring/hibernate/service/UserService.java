package com.warthur.spring.hibernate.service;

import com.warthur.spring.hibernate.dao.UserMapper;
import com.warthur.spring.hibernate.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by warthur on 17/7/15.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    // @Transactional
    public void saveUser(User user) {
        System.out.println("******************");
        userMapper.addUser(user);

        // throw new RuntimeException("error transaction rollback");
    }

    public void deleteUser(User user) {

        System.out.println("******************");
        userMapper.deleteUser(user);
    }

    @PostConstruct
    private void init() {
        System.out.println("UserService class init....");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("UserService class destroy...");
    }
}
