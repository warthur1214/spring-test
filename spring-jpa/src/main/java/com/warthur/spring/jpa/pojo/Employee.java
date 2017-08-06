package com.warthur.spring.jpa.pojo;

import com.sun.tools.corba.se.idl.constExpr.Not;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 2674946961253880639L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "e_id", length = 19)
    private long id;
    @Column(name = "e_name", columnDefinition = "varchar(10) not null default '' comment '员工姓名'")
    private String name;
    @Column(name = "e_pwd", columnDefinition = "char(32) not null default '' comment '员工姓名'")
    private String password;
    @Column(name = "e_tel", columnDefinition = "varchar(11) not null default '' comment '员工手机号'")
    private String tel;
    @UpdateTimestamp
    @Column(name = "update_time", columnDefinition="datetime not null default current_timestamp on update current_timestamp")
    private Date updateTime;
    @CreationTimestamp
    @Column(name = "create_time", columnDefinition="datetime not null default current_timestamp")
    private Date createTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}
