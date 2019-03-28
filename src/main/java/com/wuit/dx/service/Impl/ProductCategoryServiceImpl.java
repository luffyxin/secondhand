package com.wuit.dx.service.Impl;

import com.wuit.dx.dao.ProductCategoryDAO;
import com.wuit.dx.entity.Product;
import com.wuit.dx.entity.ProductCategory;
import com.wuit.dx.service.ProductCategoryService;
import com.wuit.dx.util.Page4Navigator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ${DX} on 2018/10/25.
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Resource
    private ProductCategoryDAO productCategoryDAO;

    @Override
    public Page4Navigator getAllProCate(int start, int size, int navigatePages) {
        Sort sort=new Sort(Sort.Direction.DESC,"priority");
        Pageable pageable=new PageRequest(start,size,sort);
        Page<ProductCategory> pageFromJPA = productCategoryDAO.findAll(pageable);
        Page4Navigator<ProductCategory> categoryList=new Page4Navigator<>(pageFromJPA,navigatePages);
        return categoryList;
    }

    @Override
    public ProductCategory getProCateByName(String name) {
        return productCategoryDAO.findByProductCategoryName(name);
    }

    @Override
    public void delCategory(int cid) {
        productCategoryDAO.delete(cid);
    }
}
