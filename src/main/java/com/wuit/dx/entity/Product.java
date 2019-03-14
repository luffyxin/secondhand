package com.wuit.dx.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by ${DX} on 2018/10/23.
 */
@Entity
@Table(name = "product")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Product {
    // 主键ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    // 商品名
    private String productName;
    // 商品简介
    private String productDesc;
    // 简略图
    private String imgAddr;
    // 原价
    private String normalPrice;
    // 现价
    private String promotionPrice;
    // 权重，越大越排前显示
    private Integer priority;
    // 0.下架 1.在前端展示系统展示
    private Integer enableStatus;

    // 图片详情图列表，跟商品是多对一的关系
    @Transient
    private List<ProductImg> productImgList;
    // 商品类别，一件商品仅属于一个商品类别
    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;
    // 商品属于谁的
    @ManyToOne
    @JoinColumn(name = "user_id")
    private PersonInfo personInfo;


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getImgAddr() {
        return imgAddr;
    }

    public void setImgAddr(String imgAddr) {
        this.imgAddr = imgAddr;
    }

    public String getNormalPrice() {
        return normalPrice;
    }

    public void setNormalPrice(String normalPrice) {
        this.normalPrice = normalPrice;
    }

    public String getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(String promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    public List<ProductImg> getProductImgList() {
        return productImgList;
    }

    public void setProductImgList(List<ProductImg> productImgList) {
        this.productImgList = productImgList;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }
}
