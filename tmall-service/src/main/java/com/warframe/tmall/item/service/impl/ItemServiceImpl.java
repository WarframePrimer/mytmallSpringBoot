package com.warframe.tmall.item.service.impl;


import com.warframe.tmall.common.util.FastJsonConvert;
import com.warframe.tmall.domain.TbItem;
import com.warframe.tmall.domain.TbItemDesc;
import com.warframe.tmall.redis.JedisClient;
import com.warframe.tmall.repository.TbItemDescMapper;
import com.warframe.tmall.repository.TbItemMapper;
import com.warframe.tmall.item.service.ItemService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * 商品 Service 实现
 *
 * @author xubin.
 * @create 2017-02-06 下午3:41
 */

@Service
public class ItemServiceImpl implements ItemService {

    private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    private TbItemMapper itemMapper;

    @Autowired
    private TbItemDescMapper itemDescMapper;

    @Autowired
    private JedisClient jedisClient;

    @Value("${redisKey.prefix.item_info_profix}")
    private String ITEM_INFO_PROFIX;

    @Value("${redisKey.suffix.item_info_base_suffix}")
    private String  ITEM_INFO_BASE_SUFFIX;

    @Value("${redisKey.suffix.item_info_desc_suffix}")
    private String ITEM_INFO_DESC_SUFFIX;

    @Value("${redisKey.expire_time}")
    private Integer REDIS_EXPIRE_TIME;

    @Override
    public TbItem getItemById(Long itemId) {

        String key = ITEM_INFO_PROFIX + itemId + ITEM_INFO_BASE_SUFFIX;

        try {
            String jsonItem = jedisClient.get(key);

            if (StringUtils.isNotBlank(jsonItem)) {

                logger.info("Redis 查询 商品信息 商品ID:" + itemId);

                return FastJsonConvert.convertJSONToObject(jsonItem, TbItem.class);

            } else {
                logger.error("Redis 查询不到 key:" + key);
            }
        } catch (Exception e) {
            logger.error("商品信息 获取缓存报错",e);
        }

        logger.info("根据商品ID"+itemId+"查询商品！");
        TbItem item = itemMapper.selectByPrimaryKey(itemId);

        try {
            jedisClient.set(key, FastJsonConvert.convertObjectToJSON(item));

            jedisClient.expire(key, REDIS_EXPIRE_TIME);

            logger.info("Redis 缓存商品信息 key:" + key);

        } catch (Exception e) {
            logger.error("缓存错误商品ID:" + itemId, e);
        }

        return item;

    }

    @Override
    public TbItemDesc getItemDescById(Long itemId) {

        String key = ITEM_INFO_PROFIX + itemId + ITEM_INFO_DESC_SUFFIX;

        try {
            String jsonItem = jedisClient.get(key);

            if (StringUtils.isNotBlank(jsonItem)) {

                logger.info("Redis 查询 商品详情 商品ID:" + itemId);

                return FastJsonConvert.convertJSONToObject(jsonItem, TbItemDesc.class);

            } else {
                logger.error("Redis 查询不到 key:" + key);
            }
        } catch (Exception e) {
            logger.error("商品详情 获取缓存报错",e);
        }
        logger.info("根据商品ID"+itemId+"查询商品详情！");

        TbItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(itemId);
        try {
            jedisClient.set(key, FastJsonConvert.convertObjectToJSON(itemDesc));

            jedisClient.expire(key, REDIS_EXPIRE_TIME);

            logger.info("Redis 缓存 商品详情 key:" + key);

        } catch (Exception e) {
            logger.error("缓存错误商品ID:" + itemId, e);
        }
        return itemDesc;
    }
}
