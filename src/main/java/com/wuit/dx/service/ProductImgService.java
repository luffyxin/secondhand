package com.wuit.dx.service;

import com.wuit.dx.entity.Product;
import com.wuit.dx.entity.ProductImg;

import java.util.List;

/**
 * @author dx
 * @since 2019/3/12 16:44
 */
public interface ProductImgService {

    List<ProductImg> getProductImgByProduct(Long productId);
}
