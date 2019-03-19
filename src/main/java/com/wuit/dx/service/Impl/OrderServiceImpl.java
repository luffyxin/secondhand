package com.wuit.dx.service.Impl;

import com.wuit.dx.dao.OrdersDAO;
import com.wuit.dx.dao.ProductDAO;
import com.wuit.dx.entity.Orders;
import com.wuit.dx.service.OrdersService;
import com.wuit.dx.util.Page4Navigator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dx
 * @since 2019/3/16 13:46
 */
@Service
public class OrderServiceImpl implements OrdersService {


    @Resource
    private OrdersDAO ordersDAO;

    @Resource
    private ProductDAO productDAO;

    @Override
    public Orders createOrder(Orders orders) {
        return ordersDAO.save(orders);
    }

    @Override
    public Page4Navigator<Orders> getOrderBybuyer(int buyerid,int start,int size,int navigatePages) {
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable=new PageRequest(start,size,sort);
        Page pageFromJPA= ordersDAO.findAllByBuyerId(buyerid,pageable);
        Page4Navigator<Orders> pageOrders=new Page4Navigator<>(pageFromJPA,navigatePages);
        for(Orders o:pageOrders.getContent()){
            int pid = o.getProduct().getId();
            o.setProduct(productDAO.findById(pid));
        }
        return  pageOrders;
    }
}
