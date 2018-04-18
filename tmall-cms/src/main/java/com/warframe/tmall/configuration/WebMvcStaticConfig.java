package com.warframe.tmall.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author yaojiabin
 * @Description 静态资源配置类
 * @date 2018-04-18 17:53
 */
//@Configuration
////public class WebMvcStaticConfig extends WebMvcConfigurerAdapter {
////
////    @Override
////    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////        //将所有/static/** 访问都映射到classpath:/static/ 目录下
////        //registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
////        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
////    }
////
////}