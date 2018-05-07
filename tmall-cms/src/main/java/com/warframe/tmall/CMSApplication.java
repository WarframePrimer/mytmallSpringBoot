package com.warframe.tmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;

/**
 * @author yaojiabin
 * @Description'
 * @date 2018-04-16 11:07
 */
//解决JMX重复注册bean的问题
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
@SpringBootApplication
@ServletComponentScan(basePackages = { "com.warframe.tmall"})
@ComponentScan(basePackages = { "com.warframe.tmall" })
@MapperScan(basePackages={"com.warframe.tmall.repository"})
public class CMSApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CMSApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(CMSApplication.class, args);

    }

}
