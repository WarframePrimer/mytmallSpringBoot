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
 * @date 2018-04-17 16:18
 */
// 编写一个Config，设置其指向webapp目录即可，请优化配置webapp目录
@Configuration
public class TomcatConfig {

    @Bean
    public EmbeddedServletContainerFactory embeddedServletContainerFactory() {
        ConfigurableEmbeddedServletContainer factory = new TomcatEmbeddedServletContainerFactory();
        factory.setDocumentRoot(new File("D:\\projects\\mytmallSpringBoot\\tmall-webapp\\src\\main\\webapp\\"));
        return (EmbeddedServletContainerFactory) factory;
    }
}
