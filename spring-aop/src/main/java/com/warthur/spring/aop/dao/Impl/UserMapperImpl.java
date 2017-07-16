package com.warthur.spring.aop.dao.Impl;

import com.warthur.spring.aop.dao.UserMapper;
import com.warthur.spring.aop.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by warthur on 17/7/15.
 */
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private DataSource dataSource;

    public void addUser(User user) {

        try {
            Connection connection = dataSource.getConnection();
            connection.createStatement().executeUpdate("UPDATE db_test.t_user SET user_name='warthur' WHERE id=1;");
            // connection.createStatement().executeUpdate("INSERT INTO db_test.t_user (id, user_name) VALUES (1, 'warthur');");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
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
