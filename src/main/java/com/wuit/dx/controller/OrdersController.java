package com.wuit.dx.controller;

import com.wuit.dx.entity.LocahAuth;
import com.wuit.dx.entity.Orders;
import com.wuit.dx.entity.PersonInfo;
import com.wuit.dx.service.OrdersService;
import com.wuit.dx.service.PersonInfoService;
import com.wuit.dx.util.Page4Navigator;
import com.wuit.dx.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dx
 * @since 2019/3/19 11:37
 */
@Controller
public class OrdersController {

    @Resource
    private OrdersService ordersService;

    @Resource
    private PersonInfoService personInfoService;

    /**
     * 我购买的宝贝的订单
     */
    @ResponseBody
    @GetMapping("/orders")
    public Map<String,Object> getOrdersByBuyer(
            @RequestParam(value = "start", defaultValue = "0") int start,
            @RequestParam(value = "size", defaultValue = "5") int size,
            HttpServletRequest request)throws Exception{
        start =start<0?0:start;
        LocahAuth locahAuth=(LocahAuth) request.getSession().getAttribute("user");
        Page4Navigator<Orders> page=ordersService.getOrderBybuyer(locahAuth.getId(),start,size,5);
        Map<String,Object> modle=new HashMap<>();
        modle.put("page",page);
        return modle;
    }

    /**
     * 我售卖的宝贝的订单
     */
    @ResponseBody
    @GetMapping("/ordersSell")
    public Map<String,Object>  getOrdersBySeller(
            @RequestParam(value = "start", defaultValue = "0") int start,
            @RequestParam(value = "size", defaultValue = "5") int size,
            HttpServletRequest request)throws Exception{
        start =start<0?0:start;
        LocahAuth locahAuth=(LocahAuth) request.getSession().getAttribute("user");
        Page4Navigator<Orders> page=ordersService.getOrderByseller(locahAuth.getId(),start,size,5);
        Map<String,Object> modle=new HashMap<>();
        modle.put("page",page);
        //获取买家列表
        List<PersonInfo> personInfoList =new ArrayList<>();
        for(Orders o:page.getContent()){
            PersonInfo personInfo=personInfoService.findById(o.getBuyerId());
            personInfoList.add(personInfo);
        }
        modle.put("personInfoList",personInfoList);
        return modle;
    }

    @ResponseBody
    @PutMapping("/orderStatus/{oid}")
    public Object orderStatus(@PathVariable("oid") int oid){
        Orders orders= ordersService.getOrderById(oid);
        orders.setStatus(1);
        ordersService.updateOrderStatus(orders);
        return Result.success();
    }

}
