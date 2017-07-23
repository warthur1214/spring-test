package com.warthur.spring.mybatis;

import com.warthur.spring.mybatis.dto.UserDTO;
import com.warthur.spring.mybatis.pojo.UserInfo;
import com.warthur.spring.mybatis.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.util.List;

@ContextConfiguration("classpath:spring-mybatis.xml")
public class UserInfoServiceTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private UserService userService;

    @Test
    public void getUserListTest() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        Assert.assertNotNull(userService.getUserList(userInfo));
    }
}
