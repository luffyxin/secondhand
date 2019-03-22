package com.wuit.dx.controller;

import com.wuit.dx.entity.*;
import com.wuit.dx.service.PersonInfoService;
import com.wuit.dx.service.ProductCategoryService;
import com.wuit.dx.service.ProductImgService;
import com.wuit.dx.service.ProductService;
import com.wuit.dx.util.ImageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author dx
 * @since 2019/3/20 11:26
 */
@Controller
public class ProductController {

    @Resource
    private ProductCategoryService productCategoryService;

    @Resource
    private ProductService productService;

    @Resource
    private PersonInfoService personInfoService;

    @Resource
    private ProductImgService productImgService;

    /**
     * 发布商品
     */
    @ResponseBody
    @PostMapping("/products")
    public Object publishProduct(MultipartFile [] productDetailImgsFiles,
                                 MultipartFile productImgFile, String []  product,
                                 HttpServletRequest request)throws Exception{
        Product p=new Product();
        //获取当前用户
        LocahAuth locahAuth=(LocahAuth)request.getSession().getAttribute("user");
        PersonInfo personInfo= personInfoService.findbyLocalAuth(locahAuth);
        ProductCategory pc=productCategoryService.getProCateByName(product[0]);
        //设置物品的主人
        p.setPersonInfo(personInfo);
        //设置物品分类
        p.setProductCategory(pc);
        p.setProductName(product[1]);
        p.setProductDesc(product[2]);
        p.setNormalPrice(product[3]);
        p.setPromotionPrice(product[4]);
        //设置物品状态，是否上架
        p.setEnableStatus(1);
        String pimgName=ImageUtil.getRandomFileName();
        p.setImgAddr(pimgName);
        ImageUtil.saveOrUpdateImageFile("img/productSingle_middle",pimgName,productImgFile,request);
        //保存product
        Product pro=productService.saveProduct(p);
        //保存图片
        for(int i=0;i<productDetailImgsFiles.length;i++){
            ProductImg productImg=new ProductImg();
            String imgName=ImageUtil.getRandomFileName();
            productImg.setImgAddr(imgName);
            productImg.setProductId(pro.getId());
            productImgService.saveProductImg(productImg);
            ImageUtil.saveOrUpdateImageFile("img/productDetail",imgName,productDetailImgsFiles[i],request);
        }

        return  pro;
    }
}
