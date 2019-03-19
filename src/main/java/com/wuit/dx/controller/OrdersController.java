package com.wuit.dx.controller;

import com.wuit.dx.entity.LocahAuth;
import com.wuit.dx.entity.Orders;
import com.wuit.dx.service.OrdersService;
import com.wuit.dx.util.Page4Navigator;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author dx
 * @since 2019/3/19 11:37
 */
@Controller
public class OrdersController {

    @Resource
    private OrdersService ordersService;



    @ResponseBody
    @GetMapping("/orders")
    public Page4Navigator<Orders> getOrdersByBuyer(
            @RequestParam(value = "start", defaultValue = "0") int start,
            @RequestParam(value = "size", defaultValue = "5") int size,
            HttpServletRequest request)throws Exception{
        start =start<0?0:start;
        LocahAuth locahAuth=(LocahAuth) request.getSession().getAttribute("user");
        Page4Navigator<Orders> page=ordersService.getOrderBybuyer(locahAuth.getId(),start,size,5);
        return page;
    }

}
