package com.wuit.dx.controller;

import com.wuit.dx.dao.ProductDAO;
import com.wuit.dx.entity.Product;
import com.wuit.dx.entity.ProductCategory;
import com.wuit.dx.service.ProductCategoryService;
import com.wuit.dx.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
    public Object product(@PathVariable("pid") Long pid) {
        Product p= productService.getProductById(pid);
        return  p;
    }


}
