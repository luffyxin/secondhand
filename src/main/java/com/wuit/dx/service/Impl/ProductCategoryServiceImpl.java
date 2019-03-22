package com.wuit.dx.service.Impl;

import com.wuit.dx.dao.ProductCategoryDAO;
import com.wuit.dx.entity.ProductCategory;
import com.wuit.dx.service.ProductCategoryService;
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
    public List<ProductCategory> getAllProCate() {
        return productCategoryDAO.findAll();
    }

    @Override
    public ProductCategory getProCateByName(String name) {
        return productCategoryDAO.findByProductCategoryName(name);
    }
}
