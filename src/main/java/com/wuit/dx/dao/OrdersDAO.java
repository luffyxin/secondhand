package com.wuit.dx.dao;

import com.wuit.dx.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author dx
 * @since 2019/3/16 13:40
 */
public interface OrdersDAO extends JpaRepository<Orders,Integer>{
    List<Orders> findByBuyerId(int buyerid);

    List<Orders> findBySellerId(int sellerid);

}
