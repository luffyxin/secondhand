package com.wuit.dx.dao;

import com.wuit.dx.entity.Product;
import com.wuit.dx.entity.ProductImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author dx
 * @since 2019/3/11 17:24
 */
public interface ProductImgDAO extends JpaRepository<ProductImg,Integer> {
    List<ProductImg> findByProduct(Product product);
}
