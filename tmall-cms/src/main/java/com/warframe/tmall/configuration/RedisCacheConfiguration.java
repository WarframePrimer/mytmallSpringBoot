package com.warframe.tmall.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author yaojiabin
 * @Description'
 * @date 2018-04-25 21:39
 */
@Configuration
@EnableCaching
@Slf4j
public class RedisCacheConfiguration extends CachingConfigurerSupport{

    @Value("${spring.redis.host}")
    private String hostName;

    @Value("${spring.redis.port}")
    private String port;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.timeout}")
    private String timeout;


    @Bean
    public JedisPoolConfig getRedisConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }

    @Bean
    public JedisPool getJedisPool(){
        JedisPoolConfig config = getRedisConfig();
//        int port1 = Integer.valueOf(port);
//        int timeout1 = Integer.valueOf(timeout);
        JedisPool pool = new JedisPool();
//        JedisPool pool = new JedisPool(config,hostName,port1,timeout1,password);
        log.info("init JedisPool ...");
        return pool;
    }

//    @Bean
//    public JedisPool redisPoolFactory() {
//        log.info("JedisPool注入成功！！");
////        log.info("redis地址：" + host + ":" + port);
////        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
////        jedisPoolConfig.setMaxIdle(maxIdle);
////        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
//
//        JedisPool jedisPool = new JedisPool();
//
//        return jedisPool;
//    }

}
