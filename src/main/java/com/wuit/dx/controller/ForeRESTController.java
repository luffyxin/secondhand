package com.wuit.dx.controller;

import com.wuit.dx.dao.ProductDAO;
import com.wuit.dx.entity.*;
import com.wuit.dx.service.*;
import com.wuit.dx.util.Result;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author dx
 * @since 2019/3/12 13:33
 */
@RestController
public class ForeRESTController {
    @Resource
    private ProductCategoryService productCategoryService;

    @Resource
    private ProductService productService;

    @Resource
    private LocalAuthService localAuthService;

    @Resource
    private PersonInfoService personInfoService;

    @Resource
    private OrdersService ordersService;

    @GetMapping("/forehome")
    public Object home(){
        List<ProductCategory>  cs=productCategoryService.getAllProCate();
        return cs;
    }

    @GetMapping("/products")
    public Object products(){
        return  productService.getAllProducts();
    }

    @GetMapping("/foreproduct/{pid}")
    public Object product(@PathVariable("pid") int pid) {
        Product p= productService.getProductById(pid);
        return  p;
    }

    /**
     * 是否登录验证
     * @param session
     * @return
     */
    @GetMapping("forecheckLogin")
    public Object checkLogin( HttpSession session) {
        LocahAuth user =(LocahAuth)  session.getAttribute("user");
        if(null!=user) {
            return Result.success();
        }
        return Result.fail("未登录");
    }

    @PostMapping("forelogin")
    public Object login(@RequestBody LocahAuth user, HttpSession session){
        LocahAuth auth=  localAuthService.loginAuth(user);
        if(null==auth){
            String message ="账号密码错误";
            return Result.fail(message);
        }
        else{
            session.setAttribute("user", auth);
            return Result.success();
        }
    }
    @PostMapping("forecreateOrder")
    public void createOrder(@RequestBody Orders orders,HttpSession session){
        LocahAuth auth= (LocahAuth) session.getAttribute("user");
        orders.setBuyerId(auth.getId());
        String orderNo = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + RandomUtils.nextInt(10000);
        orders.setOrderNo(orderNo);
        orders.setCreateDate(new Date());
        orders.setStatus(0);
        ordersService.createOrder(orders);
    }

    @GetMapping("foreperson")
    public Object getPersonInfo(HttpSession session){
        LocahAuth auth = (LocahAuth) session.getAttribute("user");
        PersonInfo p = personInfoService.findbyLocalAuth(auth);
        return p;
    }

}
