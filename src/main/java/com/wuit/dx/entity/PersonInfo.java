package com.wuit.dx.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by ${DX} on 2018/10/23.
 */
@Entity
@Table(name = "person_info")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class PersonInfo {
    // 主键ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;
    // 用户名称
    private String name;
    // 用户头像
    private String profileImg;
    // 用户邮箱
    private String email;
    // 用户性别
    private String gender;
    //用户电话
    private String tel;

    //用户地址
    private String address;

    // 可用状态：0、被禁止 1、可用
    private Integer enableStatus;
    // 1.顾客 2.超级管理员
    private Integer userType;
    // 用户拥有的商品
    @Transient
    private List<Product> products;
    // 属于哪个账号
    @OneToOne
    @JoinColumn (name = "local_auth_id")
    private LocahAuth localAuth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocahAuth getLocalAuth() {
        return localAuth;
    }

    public void setLocalAuth(LocahAuth localAuth) {
        this.localAuth = localAuth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
