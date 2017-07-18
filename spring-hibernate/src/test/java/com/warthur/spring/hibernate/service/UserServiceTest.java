package com.warthur.spring.hibernate.service;

import com.warthur.spring.hibernate.dao.Impl.UserMapperImpl;
import com.warthur.spring.hibernate.dao.UserMapper;
import com.warthur.spring.hibernate.interceptor.LogProxyInterceptor;
import com.warthur.spring.hibernate.pojo.User;
import com.warthur.spring.hibernate.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Proxy;

/**
 * Created by warthur on 17/7/15.
 */
public class UserServiceTest {

    @Test
    public void addUser() {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");

        UserService service = (UserService) applicationContext.getBean("userService");

        System.out.println(service.getClass());

        service.saveUser(new User("wuyongqiang", 27));

        applicationContext.destroy();
    }

    @Test
    public void testProxy() {

        UserMapper userMapper = new UserMapperImpl();

        UserMapper userMapperProxy = (UserMapper) Proxy.newProxyInstance(userMapper.getClass().getClassLoader(),
                new Class[]{UserMapper.class},
                new LogProxyInterceptor(userMapper));

        System.out.println(userMapperProxy.getClass());

        userMapperProxy.deleteUser(new User("wuyongqiang", 27));
    }
}
