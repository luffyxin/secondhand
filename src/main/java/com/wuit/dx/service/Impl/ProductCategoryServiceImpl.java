package com.wuit.dx.service.Impl;

import com.wuit.dx.entity.ProductCategory;
import com.wuit.dx.mapper.ProductCategoryMapper;
import com.wuit.dx.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ${DX} on 2018/10/25.
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductCategory> getAllProCate() {
        return productCategoryMapper.getAllCategory();
    }
}
