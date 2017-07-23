package com.warthur.spring.mybatis.dao;

import com.warthur.spring.mybatis.dto.UserDTO;
import com.warthur.spring.mybatis.pojo.UserInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {

    List<UserDTO> selectUserList(UserInfo userInfo);

    @Select("select user_name as userName, age from db_test.tp_user where id=:id")
    UserDTO findUserInfoById(UserInfo userInfo);
}
