package com.wuit.dx.dao;

import com.wuit.dx.entity.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dx
 * @since 2019/3/16 13:40
 */
public interface OrdersDAO extends JpaRepository<Orders,Integer>{
    Page<Orders> findAllByBuyerId(int buyerid, Pageable pageable);

    Page<Orders> findAllBySellerId(int sellerid , Pageable pageable);

    
}
