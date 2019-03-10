package com.wuit.dx.mapper;

import com.wuit.dx.entity.ProductCategory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ${DX} on 2018/10/23.
 */
@Component
public interface ProductCategoryMapper {
    public List<ProductCategory> getAllCategory();
}
