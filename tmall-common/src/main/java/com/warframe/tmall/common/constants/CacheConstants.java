package com.warframe.tmall.common.constants;

/**
 * @Author warframe[github.com/WarframePrimer]
 * @Date 2018/4/14 14:29
 */
public interface CacheConstants {

    //所属系统
    String BASE_DOMAIN = "warframe:tmall:";


    //redis全局失效时间设置为一天
    Long REDIS_EXPIRATION = 24 * 60 * 60L;
}
