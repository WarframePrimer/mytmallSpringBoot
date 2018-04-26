package com.warframe.tmall.portal.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

/**
 * @author yaojiabin
 * @Description'
 * @date 2018-04-25 21:39
 */
@Configuration
@EnableCaching
@Slf4j
public class RedisCacheConfiguration extends CachingConfigurerSupport{

    @Bean
    public JedisPool redisPoolFactory() {
        log.info("JedisPool注入成功！！");
//        log.info("redis地址：" + host + ":" + port);
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxIdle(maxIdle);
//        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);

        JedisPool jedisPool = new JedisPool();

        return jedisPool;
    }

}
