package com.wuit.dx;

import com.wuit.dx.entity.LocahAuth;

import com.wuit.dx.mapper.LocahAuthMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SecondhandApplicationTests {

	@Autowired
	private LocahAuthMapper locahAuthMapper;


	@Test
	public void contextLoads() {

		LocahAuth locahAuth=locahAuthMapper.getAuthByName("dengxin");
		System.out.println(locahAuth.getUsername());

	}

	@Test
	public void insertAuth(){
		LocahAuth locahAuth=new LocahAuth();
		locahAuth.setUsername("dengxin01070");
		locahAuth.setPassword("123456789");
		locahAuth.setCreateTime(new Date());
		locahAuth.setLastEditTime(new Date());
		int i=locahAuthMapper.insertAuth(locahAuth);
		System.out.println(i);

	}

}
