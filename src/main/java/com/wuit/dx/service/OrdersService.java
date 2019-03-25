package com.wuit.dx.service;

import com.wuit.dx.entity.Orders;
import com.wuit.dx.util.Page4Navigator;

import java.util.List;

/**
 * @author dx
 * @since 2019/3/16 13:46
 */
public interface OrdersService {

    Orders createOrder(Orders orders);

    Page4Navigator<Orders> getOrderBybuyer(int buyerid,int start,int size,int navigatePages);

    Page4Navigator<Orders> getOrderByseller(int buyerid,int start,int size,int navigatePages);
}
