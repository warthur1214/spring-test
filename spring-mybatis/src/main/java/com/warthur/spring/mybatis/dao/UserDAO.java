package com.warthur.spring.mybatis.dao;

import com.warthur.spring.mybatis.dto.UserDTO;
import com.warthur.spring.mybatis.pojo.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {

    List<UserDTO> selectUserList(UserInfo userInfo);
}
