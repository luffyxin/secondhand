package com.wuit.dx.dao;

import com.wuit.dx.entity.PersonInfo;
import com.wuit.dx.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author dx
 * @since 2019/3/11 17:03
 */
public interface ProductDAO extends JpaRepository<Product,Integer> {
    Product findById(int id);

    List<Product> findAllByEnableStatus(int enableStatus);

    List<Product> findByPersonInfo(PersonInfo personInfo);
}
