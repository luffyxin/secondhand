package com.wuit.dx.dao;

import com.wuit.dx.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dx
 * @since 2019/3/11 17:24
 */
public interface ProductCategoryDAO extends JpaRepository<ProductCategory,Integer> {

    ProductCategory findByProductCategoryName(String name);
}
