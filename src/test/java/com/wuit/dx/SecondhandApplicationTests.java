package com.wuit.dx;

import com.wuit.dx.dao.ProductCategoryDAO;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SecondhandApplicationTests {

	@Resource
	private ProductCategoryDAO productCategoryDAO;
	@Test
	public void test(){
		productCategoryDAO.findAll();
	}

}
