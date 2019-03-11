package com.wuit.dx.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ${DX} on 2018/10/23.
 */
@Entity
@Table(name = "product_img")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class ProductImg {

    // 主键ID
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "product_img_id")
    private Long productImgId;
    // 图片地址
    private String imgAddr;
    // 图片简介
    private String imgDesc;
    // 权重，越大越排前显示
    private Integer priority;
    // 创建时间
    private Date createTime;
    // 标明是属于哪个商品的图片
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productId;

    public Long getProductImgId() {
        return productImgId;
    }

    public void setProductImgId(Long productImgId) {
        this.productImgId = productImgId;
    }

    public String getImgAddr() {
        return imgAddr;
    }

    public void setImgAddr(String imgAddr) {
        this.imgAddr = imgAddr;
    }

    public String getImgDesc() {
        return imgDesc;
    }

    public void setImgDesc(String imgDesc) {
        this.imgDesc = imgDesc;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }
}
