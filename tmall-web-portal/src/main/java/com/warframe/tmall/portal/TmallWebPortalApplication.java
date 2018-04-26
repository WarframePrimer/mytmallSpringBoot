package com.warframe.tmall.portal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yaojiabin
 * @Description
 * @date 2018-04-16 10:59
 */
@SpringBootApplication
@ServletComponentScan(basePackages = { "com.warframe.tmall"})
@ComponentScan(basePackages = { "com.warframe.tmall" })
@MapperScan(basePackages={"com.warframe.tmall.repository"})
public class TmallWebPortalApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(TmallWebPortalApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(TmallWebPortalApplication.class, args);
    }

}
