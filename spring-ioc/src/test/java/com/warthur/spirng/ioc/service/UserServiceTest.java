package com.warthur.spirng.ioc.service;

import com.warthur.spring.ioc.dao.UserDAO;
import com.warthur.spring.ioc.model.User;
import com.warthur.spring.ioc.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by warthur on 17/7/9.
 */
public class UserServiceTest {

    @Test
    public void AddUser() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        UserService service = (UserService) applicationContext.getBean("userService");
        UserService service1 = (UserService) applicationContext.getBean("userService");

        System.out.println(service == service1);

        UserDAO userDAO = (UserDAO) applicationContext.getBean("userDao");

        User user = new User("warthur", "123456");
        service.addUser(user);

        userDAO.saveUser(user);

        applicationContext.destroy();
    }
}
