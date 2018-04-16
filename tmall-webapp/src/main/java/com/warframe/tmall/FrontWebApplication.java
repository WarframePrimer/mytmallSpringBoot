package com.warframe.tmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author yaojiabin
 * @Description
 * @date 2018-04-16 10:59
 */
@SpringBootApplication
public class FrontWebApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FrontWebApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(FrontWebApplication.class, args);
    }

}
