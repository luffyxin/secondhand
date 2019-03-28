package com.wuit.dx.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by ${DX} on 2018/10/23.
 */
@Entity
@Table(name = "local_auth")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class LocahAuth {

    // 主键ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    // 帐号
    private String username;
    // 密码
    private String password;

    //可用状态
    private  int enable;

    //账号类型 0 网站会员 1 管理员
    private int userType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
