package com.wuit.dx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.wuit.dx.mapper")
@SpringBootApplication
public class SecondhandApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondhandApplication.class, args);
	}
}
