package com.wuit.dx.entity;

import java.util.Date;

/**
 * Created by ${DX} on 2018/10/23.
 */
public class ProductCategory {

    // 主键ID
    private Long productCategoryId;
    // 类别名
    private String productCategoryName;
    // 权重，越大越排前显示
    private Integer priority;
    // 创建时间
    private Date createTime;
    // 父类别
    private ProductCategory parent;

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
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

    @Override
    public String toString() {
        return "ProductCategory{" +
                "productCategoryId=" + productCategoryId +
                ", productCategoryName='" + productCategoryName + '\'' +
                ", priority=" + priority +
                ", createTime=" + createTime +
                ", parent=" + parent +
                '}';
    }
}
