package com.warthur.spring.mybatis.service;

import com.warthur.spring.mybatis.dao.UserDAO;
import com.warthur.spring.mybatis.dto.UserDTO;
import com.warthur.spring.mybatis.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public List<UserDTO> getUserList(UserInfo userInfo) {
        return userDAO.selectUserList(userInfo);
    }

    public UserDTO getUserInfoById(UserInfo userInfo) {
        return userDAO.findUserInfoById(userInfo);
    }
}
