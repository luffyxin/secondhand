package com.wuit.dx.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ${DX} on 2018/10/23.
 */
@Entity
@Table(name = "product_category")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class ProductCategory {

    // 主键ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long Id;
    // 类别名
    private String productCategoryName;
    // 权重，越大越排前显示
    private Integer priority;
    // 创建时间
    private Date createTime;
    // 父类别
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private ProductCategory parent;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
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

    public ProductCategory getParent() {
        return parent;
    }

    public void setParent(ProductCategory parent) {
        this.parent = parent;
    }


}
