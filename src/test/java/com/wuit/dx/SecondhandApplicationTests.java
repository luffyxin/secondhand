package com.wuit.dx;

import com.wuit.dx.dao.ProductCategoryDAO;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.net.URL;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SecondhandApplicationTests {

	@Test
	public void test(){
		URL url = this.getClass().getClassLoader().getResource("file");
		File file = new File(url.getPath());
	}

}
