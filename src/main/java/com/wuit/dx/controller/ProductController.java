package com.wuit.dx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author dx
 * @since 2019/3/20 11:26
 */
@Controller
public class ProductController {


    @PostMapping("/products")
    public String publishProduct(MultipartFile [] productDetailImgsFiles,
                                 MultipartFile productImgFile, String []  product,
                                 HttpServletRequest request){
        System.out.println(product);
        return  "fore/hasPublish";
    }

}
