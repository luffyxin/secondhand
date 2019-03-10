package com.wuit.dx.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by ${DX} on 2018/10/27.
 */
@Configuration
public class MyWebConfigcation extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("index.html").setViewName("index");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/login").setViewName("login");
    }
}
