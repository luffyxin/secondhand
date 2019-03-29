package com.wuit.dx.service;

import com.wuit.dx.entity.ProductCategory;
import com.wuit.dx.util.Page4Navigator;

/**
 * Created by ${DX} on 2018/10/25.
 */

public interface ProductCategoryService {

    Page4Navigator<ProductCategory> getAllProCate(int start,int size,int navigatePages);

    ProductCategory getProCateByName(String name);

    void delCategory(int cid);

    ProductCategory updateCategory(ProductCategory productCategory);
}
