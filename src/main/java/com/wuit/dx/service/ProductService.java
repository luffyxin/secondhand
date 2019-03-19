package com.wuit.dx.service;

import com.wuit.dx.entity.Product;

import java.util.List;

/**
 * @author dx
 * @since 2019/3/12 14:17
 */
public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(int id);

    Product sellProduct(int id);
}
