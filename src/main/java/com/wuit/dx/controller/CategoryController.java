package com.wuit.dx.controller;

import com.wuit.dx.service.ProductCategoryService;
import com.wuit.dx.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author dx
 * @since 2019/3/28 16:34
 */
@Controller
public class CategoryController {

    @Resource
    private ProductCategoryService productCategoryService;

    @ResponseBody
    @DeleteMapping("/categories/{cid}")
    public Object delete(@PathVariable("cid") int cid){
        productCategoryService.delCategory(cid);
        return Result.success();
    }
}
