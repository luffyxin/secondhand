package com.wuit.dx.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

/**
 * @author dx
 * @since 2019/3/13 13:13
 */
@Entity
@Table(name = "orders")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     *  订单号
     */
    private String orderNo;

    /**
     * 买家id
     */
    private Long buyerId;
    /**
     * 卖家id
     */
    private Long sellerId;

    /**
     * 商品
     */
    @OneToOne
    @JoinColumn(name = "pid")
    private Product product;

    /**
     * 交易地址
     */
    private String address;
    /**
     *  买家留言
     */
    private String message;

    /**
     *  创建日期
     */
    private Date createDate;

    /**
     *  完成交易日期
     */
    private Date confirmDate;
    /**
     *  订单状态
     */
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
