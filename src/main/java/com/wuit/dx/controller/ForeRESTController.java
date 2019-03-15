package com.wuit.dx.controller;

import com.wuit.dx.dao.ProductDAO;
import com.wuit.dx.entity.LocahAuth;
import com.wuit.dx.entity.Product;
import com.wuit.dx.entity.ProductCategory;
import com.wuit.dx.service.LocalAuthService;
import com.wuit.dx.service.ProductCategoryService;
import com.wuit.dx.service.ProductService;
import com.wuit.dx.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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


}
