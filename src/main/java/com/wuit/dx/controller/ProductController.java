package com.wuit.dx.controller;

import com.wuit.dx.entity.*;
import com.wuit.dx.service.PersonInfoService;
import com.wuit.dx.service.ProductCategoryService;
import com.wuit.dx.service.ProductImgService;
import com.wuit.dx.service.ProductService;
import com.wuit.dx.util.ImageUtil;
import com.wuit.dx.util.Page4Navigator;
import com.wuit.dx.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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

    /**
     * 获取我发布的宝贝
     */
    @ResponseBody
    @GetMapping("/myPublishes")
    public Map<String,Object> getMyPublishProduct(@RequestParam(value = "start", defaultValue = "0") int start,
    @RequestParam(value = "size", defaultValue = "5") int size,
    HttpServletRequest request)throws Exception{
        LocahAuth locahAuth=(LocahAuth)request.getSession().getAttribute("user");
        PersonInfo personInfo=new PersonInfo();
        personInfo.setId(locahAuth.getId());
        Page4Navigator<Product> page = productService.getProductByPerson(personInfo, start, size, 5);
        Map<String,Object> model=new HashMap<>();
        model.put("page",page);
        return  model;
    }

    @ResponseBody
    @PutMapping("productEnable/{id}")
    public Object productEnable(@PathVariable("id") int id){
        Product product= productService.getProductById(id);
        product.setEnableStatus(product.getEnableStatus()==0?1:0);
        productService.saveProduct(product);
        return Result.success();
    }

    @ResponseBody
    @GetMapping("/productsAdmin")
    public Map<String, Object> products(@RequestParam(value = "start", defaultValue = "0") int start,
                                        @RequestParam(value = "size", defaultValue = "5") int size)throws Exception {
        Page4Navigator<Product> page = productService.getAllProductsAdmin(start, size, 5);
        Map<String, Object> model = new HashMap<>();
        model.put("page", page);
        return model;
    }
}
