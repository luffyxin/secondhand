package com.wuit.dx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author dx
 * @since 2019/3/28 9:09
 */
@Controller
public class AdminPageController {

    @GetMapping("/admin")
    public String admin(){
        return "admin/admin";
    }
}
