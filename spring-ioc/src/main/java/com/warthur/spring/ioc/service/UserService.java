package com.warthur.spring.ioc.service;


import com.warthur.spring.ioc.dao.UserDAO;
import com.warthur.spring.ioc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by warthur on 17/7/7.
 */
@Service
// @Scope("prototype")  默认单例singleton
public class UserService {

    // @Autowired   注入xml的bean配置
    @Resource  // 1. 注入xml的bean配置 2. 注入component-scan扫描到的bean
    private UserDAO userDao;
    @Resource
    private Properties properties;
    @Resource
    private List<String> list;
    @Resource
    private Map<String, String> userMap;

    @PostConstruct
    public void init() {
        System.out.println("userService initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("userService destroy");
    }

    public void addUser(User u) {
        userDao.saveUser(u);
    }
}
