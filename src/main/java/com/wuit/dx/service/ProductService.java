package com.wuit.dx.service;

import com.wuit.dx.entity.PersonInfo;
import com.wuit.dx.entity.Product;
import com.wuit.dx.entity.ProductCategory;
import com.wuit.dx.util.Page4Navigator;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author dx
 * @since 2019/3/12 14:17
 */
public interface ProductService {

    Page4Navigator<Product> getAllProducts(int start,int size,int navigatePages);

    Product getProductById(int id);

    Product sellProduct(int id);

    Product saveProduct(Product product);

    Page4Navigator<Product> getProductByPerson(PersonInfo personInfo,int start,int size,int navigatePages);

    Page4Navigator<Product> getProductByCategory(ProductCategory productCategory,int start,int size,int navigatePages);
}
