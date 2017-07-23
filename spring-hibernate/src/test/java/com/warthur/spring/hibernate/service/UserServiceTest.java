package com.warthur.spring.hibernate.service;

import com.warthur.spring.hibernate.dao.Impl.UserMapperImpl;
import com.warthur.spring.hibernate.dao.UserMapper;
import com.warthur.spring.hibernate.interceptor.LogProxyInterceptor;
import com.warthur.spring.hibernate.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by warthur on 17/7/15.
 */
@ContextConfiguration("classpath:spring-config.xml")
public class UserServiceTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private UserService service;

    @Test
    public void addUser() {
        service.saveUser(new User("wuyongqiang1", 27));
    }

    @Test
    public void deleteUser() {

        UserService service = (UserService) applicationContext.getBean("userService");
        service.deleteUser(new User("wuyongqiang", 27));
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

    @Test
    public void testArrayList() {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        System.out.println(list);
    }
}
