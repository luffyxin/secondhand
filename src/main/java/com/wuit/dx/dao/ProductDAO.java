package com.wuit.dx.dao;

import com.wuit.dx.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dx
 * @since 2019/3/11 17:03
 */
public interface ProductDAO extends JpaRepository<Product,Integer> {
    
}
