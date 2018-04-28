package com.warframe.tmall.configuration;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * @author yaojiabin
 * @Description'
 * @date 2018-04-28 9:49
 */
@Configuration
public class TomcatConfig {

    @Bean
    public EmbeddedServletContainerFactory embeddedServletContainerFactory() {
        ConfigurableEmbeddedServletContainer factory = new TomcatEmbeddedServletContainerFactory();
//        factory.setDocumentRoot(new File("D:\\Workspace\\IDEA\\spring-boot-web-demo\\src\\main\\webapp\\"));
        factory.setDocumentRoot(new File("D:\\projects\\mytmallSpringBoot\\tmall-cms\\src\\main\\webapp\\"));
        return (EmbeddedServletContainerFactory) factory;
    }
}
