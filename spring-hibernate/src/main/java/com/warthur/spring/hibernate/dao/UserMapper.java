package com.warthur.spring.hibernate.dao;

import com.warthur.spring.hibernate.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * Created by warthur on 17/7/15.
 */
@Repository
public interface UserMapper {

    void addUser(User user);

    void deleteUser(User user);
}
