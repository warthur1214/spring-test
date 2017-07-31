package com.warthur.spring.webmvc.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void save() {
        System.out.println("userService -> save function");
    }
}
