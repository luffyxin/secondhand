package com.wuit.dx.controller;

import com.wuit.dx.entity.ProductCategory;
import com.wuit.dx.service.ProductCategoryService;
import com.wuit.dx.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @ResponseBody
    @PutMapping("/categories")
    public Object update(@RequestBody ProductCategory category){
        productCategoryService.updateCategory(category);
        return Result.success();
    }

    @ResponseBody
    @PostMapping("/categories")
    public Object add(@RequestBody ProductCategory category){
        productCategoryService.addCategory(category);
        return Result.success();
    }
}
