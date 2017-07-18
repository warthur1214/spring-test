package com.warthur.spring.hibernate.pojo;

import javax.persistence.*;

/**
 * Created by warthur on 17/7/15.
 */
@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_name", length = 20)
    private String userName;
    @Column
    private Integer age;

    public User() {
    }

    public User(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
