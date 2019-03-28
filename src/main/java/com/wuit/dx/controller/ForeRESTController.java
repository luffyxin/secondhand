package com.wuit.dx.controller;

import com.wuit.dx.entity.*;
import com.wuit.dx.service.*;
import com.wuit.dx.util.Page4Navigator;
import com.wuit.dx.util.Result;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public Map<String,Object> home(@RequestParam(value = "start",
            defaultValue = "0") int start, @RequestParam(value = "size",
            defaultValue = "6") int size, HttpServletRequest request)
            throws Exception{
        Page4Navigator<ProductCategory> page =productCategoryService.getAllProCate(start,size,5);
        Map<String,Object> model=new HashMap<>();
        model.put("page",page);
        return model;
    }

    @GetMapping("/products")
    public Map<String, Object> products(@RequestParam(value = "start", defaultValue = "0") int start,
                           @RequestParam(value = "size", defaultValue = "5") int size,
                           HttpServletRequest request)throws Exception {
        Page4Navigator<Product> page = productService.getAllProducts(start, size, 5);
        Map<String, Object> model = new HashMap<>();
        model.put("page", page);
        return model;
    }

    @GetMapping("/productBycate")
    public Map<String,Object> getProductsBycate(@RequestParam(value = "start",
            defaultValue = "0") int start, @RequestParam(value = "size",
            defaultValue = "5") int size,@RequestParam int cid, HttpServletRequest request)
            throws Exception {
        ProductCategory productCategory=new ProductCategory();
        productCategory.setId(cid);
        Page4Navigator<Product> page = productService.getProductByCategory(productCategory,start, size, 5);
        Map<String, Object> model = new HashMap<>();
        model.put("page", page);
        return model;
    }

    @GetMapping("/searchProduct")
    public Map<String,Object> searchProduct(@RequestParam(value = "start",
            defaultValue = "0") int start, @RequestParam(value = "size",
            defaultValue = "5") int size,@RequestParam String keyword, HttpServletRequest request)
            throws Exception {
        if(null==keyword){
            keyword = "";
        }
        Page4Navigator<Product> page = productService.searchProduct(keyword,start, size, 5);
        Map<String, Object> model = new HashMap<>();
        model.put("page", page);
        return model;
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
