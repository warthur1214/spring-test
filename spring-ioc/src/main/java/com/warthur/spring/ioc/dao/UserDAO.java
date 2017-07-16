package com.warthur.spring.ioc.dao;


import com.warthur.spring.ioc.model.User;

/**
 * Created by warthur on 17/7/7.
 */
public interface UserDAO {

    void saveUser(User user);
}
