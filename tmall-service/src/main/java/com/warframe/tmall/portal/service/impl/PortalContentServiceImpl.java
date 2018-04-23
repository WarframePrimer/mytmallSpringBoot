package com.warframe.tmall.portal.service.impl;


import com.warframe.tmall.common.util.FastJsonConvert;
import com.warframe.tmall.domain.TbContent;
import com.warframe.tmall.domain.TbContentExample;
import com.warframe.tmall.portal.service.PortalContentService;
import com.warframe.tmall.redis.JedisClient;
import com.warframe.tmall.repository.TbContentMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 首页内容Service
 * Created by cynicism on 17/1/28.
 */
@Service
@Transactional
public class PortalContentServiceImpl implements PortalContentService {

    private static Logger logger = Logger.getLogger(PortalContentServiceImpl.class);

    @Autowired
    private TbContentMapper contentMapper;

    @Autowired
    private JedisClient jedisClient;

    @Value("${redisKey.prefix.index_ad}")
    private String INDEX_AD;


    @Override
    public List<TbContent> getContentByCid(long bigAdIndex) {

        //先查询缓存

        try {
            logger.info("=====>查询Redis");
            String list = jedisClient.hget(INDEX_AD, bigAdIndex + "");

            if (StringUtils.isNotBlank(list)) {

                logger.info("=======>查询Redis 返回结果");
                return FastJsonConvert.convertJSONToArray(list, TbContent.class);
            }

        } catch (Exception e) {
            logger.error(e);
        }


        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(bigAdIndex);

        logger.info("=======>查询数据库");
        List<TbContent> list = contentMapper.selectByExample(example);

        //添加缓存
        try {
            logger.info("=======>添加缓存");
            jedisClient.hset(INDEX_AD, bigAdIndex + "", FastJsonConvert.convertObjectToJSON(list));
        } catch (Exception e) {
            logger.error(e);
        }

        return list;

    }

}
