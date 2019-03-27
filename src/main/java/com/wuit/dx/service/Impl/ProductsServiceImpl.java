package com.wuit.dx.service.Impl;

import com.wuit.dx.dao.PersonInfoDAO;
import com.wuit.dx.dao.ProductDAO;
import com.wuit.dx.dao.ProductImgDAO;
import com.wuit.dx.entity.*;
import com.wuit.dx.service.ProductService;
import com.wuit.dx.util.Page4Navigator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dx
 * @since 2019/3/12 14:18
 */
@Service
public class ProductsServiceImpl implements ProductService {
    @Resource
    private ProductDAO productDAO;

    @Resource
    private PersonInfoDAO personInfoDAO;

    @Resource
    private ProductImgDAO productImgDAO;
    @Override
    public Page4Navigator<Product> getAllProducts(int start,int size,int navigatePages) {
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable=new PageRequest(start,size,sort);
        Page<Product> pageFromJPA = productDAO.findAllByEnableStatus(1,pageable);
        Page4Navigator<Product> products=new Page4Navigator<>(pageFromJPA,navigatePages);
        for (Product p : products.getContent()) {
            if (p.getPersonInfo() != null) {
                p.setPersonInfo(personInfoDAO.findById(p.getPersonInfo().getId()));
            }
        }
        return products;
    }

    @Override
    public Product getProductById(int id) {
        Product p=productDAO.findById(id);
        if(p!=null){
            List<ProductImg> productImgs=productImgDAO.findByProductId(p.getId());
            p.setProductImgList(productImgs);
            if(p.getPersonInfo()!=null){
                p.setPersonInfo(personInfoDAO.findById(p.getPersonInfo().getId()));
            }
        }
        return p;
    }

    @Override
    public Product sellProduct(int id) {
        Product p=productDAO.findById(id);
        p.setEnableStatus(0);
        return  productDAO.save(p);
    }

    @Override
    public Product saveProduct(Product product) {
        return productDAO.save(product);
    }

    @Override
    public Page4Navigator<Product> getProductByPerson(PersonInfo personInfo,int start,int size,int navigatePages) {
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable=new PageRequest(start,size,sort);
        Page pageFromJPA= productDAO.findAllByEnableStatusAndPersonInfo(1,personInfo,pageable);
        Page4Navigator<Product> products=new Page4Navigator<>(pageFromJPA,navigatePages);
        return  products;
    }

    @Override
    public Page4Navigator<Product> getProductByCategory(ProductCategory productCategory, int start, int size, int navigatePages) {
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable=new PageRequest(start,size,sort);
        Page pageFromJPA= productDAO.findAllByEnableStatusAndProductCategory(1,productCategory,pageable);
        Page4Navigator<Product> products=new Page4Navigator<>(pageFromJPA,navigatePages);
        return  products;
    }

    @Override
    public Page4Navigator<Product> searchProduct(String keyword, int start, int size, int navigatePages) {
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable=new PageRequest(start,size,sort);
        Page pageFromJPA= productDAO.findByProductNameLike("%"+keyword+"%",pageable);
        Page4Navigator<Product> products=new Page4Navigator<>(pageFromJPA,navigatePages);
        return  products;
    }
}
