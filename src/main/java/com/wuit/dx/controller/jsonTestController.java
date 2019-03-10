package com.wuit.dx.controller;

import com.wuit.dx.entity.ProductCategory;
import com.wuit.dx.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ${DX} on 2018/10/25.
 */
@Controller
public class jsonTestController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @ResponseBody
    @RequestMapping("/getCate")
    public List<ProductCategory> test(){
        return productCategoryService.getAllProCate();
    }

    @RequestMapping("/category")
    public String productCategory(){
        return "jsontest";
    }

}
