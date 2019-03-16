package com.wuit.dx.service.Impl;

import com.wuit.dx.dao.OrdersDAO;
import com.wuit.dx.entity.Orders;
import com.wuit.dx.service.OrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author dx
 * @since 2019/3/16 13:46
 */
@Service
public class OrderServiceImpl implements OrdersService {


    @Resource
    private OrdersDAO ordersDAO;

    @Override
    public Orders createOrder(Orders orders) {
        return ordersDAO.save(orders);
    }
}
