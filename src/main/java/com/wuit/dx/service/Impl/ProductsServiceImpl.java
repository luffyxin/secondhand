package com.wuit.dx.service.Impl;

import com.wuit.dx.dao.PersonInfoDAO;
import com.wuit.dx.dao.ProductDAO;
import com.wuit.dx.dao.ProductImgDAO;
import com.wuit.dx.entity.PersonInfo;
import com.wuit.dx.entity.Product;
import com.wuit.dx.entity.ProductImg;
import com.wuit.dx.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dx
 * @since 2019/3/12 14:18
 */
@Service
public class ProductsServiceImpl implements ProductService {
    @Resource
    private ProductDAO productDAO;

    @Resource
    private PersonInfoDAO personInfoDAO;

    @Resource
    private ProductImgDAO productImgDAO;
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productDAO.findAllByEnableStatus(1);
        for (Product p : products) {
            if (p.getPersonInfo() != null) {
                p.setPersonInfo(personInfoDAO.findById(p.getPersonInfo().getId()));
            }
        }
        return products;
    }

    @Override
    public Product getProductById(int id) {
        Product p=productDAO.findById(id);
        if(p!=null){
            List<ProductImg> productImgs=productImgDAO.findByProductId(p.getId());
            p.setProductImgList(productImgs);
            if(p.getPersonInfo()!=null){
                p.setPersonInfo(personInfoDAO.findById(p.getPersonInfo().getId()));
            }
        }
        return p;
    }

    @Override
    public Product sellProduct(int id) {
        Product p=productDAO.findById(id);
        p.setEnableStatus(0);
        return  productDAO.save(p);
    }
}
