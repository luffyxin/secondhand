package com.wuit.dx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转
 * @author dx
 * @since 2019/3/11 10:46
 */
@Controller
public class ForePageController {

    @RequestMapping("/personcenter")
    public String personCenter(){
        return "fore/personcenter";
    }

    @GetMapping("/")
    public String index(){
        return  "redirect:home";
    }

    @GetMapping("/home")
    public String home(){
        return "fore/home";
    }

    @GetMapping(value="/product")
    public String product(){
        return "fore/product";
    }

    @GetMapping("/buyone")
    public String buy(){
        return "fore/buy";
    }

    @GetMapping("/personcenter")
    public String center(){
        return "fore/personcenter";
    }

    @GetMapping("/mybuy")
    public String mybuy(){
        return "fore/mybuy";
    }

    @GetMapping("/publish")
    public String publish(){
        return "fore/publish";
    }

    @GetMapping("/myOrder")
    public String myOrder(){
        return "fore/myOrder";
    }

    @GetMapping("/myPublish")
    public String myPublish(){
        return "fore/myPublish";
    }

    @GetMapping("/passWd")
    public String passwd(){
        return "fore/passWd";
    }

    @GetMapping("/category")
    public String category(){
        return "fore/category";
    }
}
