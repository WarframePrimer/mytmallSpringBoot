package com.warframe.tmall.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Type ThreadPoolConfig.java
 * @Desc
 * @date 2017年8月11日 下午2:03:32
 * @version 
 */
@ConfigurationProperties(prefix = "spring.threadPool")
@Configuration
@EnableAsync
@Data
public class ThreadPoolConfig {

    private int corePoolSize;

    private int maxPoolSize;

    private int queueCapacity;

    private int keepAliveSeconds;

    private static final String THREAD_NAME_PREFIX = "tmallCMSTaskExecutor-";

    @Bean
    public ThreadPoolTaskExecutor tmallCMSTaskExecutor() {
        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        threadPool.setCorePoolSize(corePoolSize);
        threadPool.setMaxPoolSize(maxPoolSize);
        threadPool.setQueueCapacity(queueCapacity);
        threadPool.setKeepAliveSeconds(keepAliveSeconds);
        threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPool.setThreadNamePrefix(THREAD_NAME_PREFIX);
        threadPool.initialize();
        return threadPool;
    }
    
}

