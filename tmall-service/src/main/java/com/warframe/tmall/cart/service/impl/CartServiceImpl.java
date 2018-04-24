package com.warframe.tmall.cart.service.impl;


import com.warframe.tmall.cart.service.CartService;
import com.warframe.tmall.common.pojo.XbinResult;
import com.warframe.tmall.common.util.FastJsonConvert;
import com.warframe.tmall.domain.CartInfo;
import com.warframe.tmall.domain.TbItem;
import com.warframe.tmall.domain.TbItemExample;
import com.warframe.tmall.redis.JedisClient;
import com.warframe.tmall.repository.TbItemMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车操作实现
 *
 * @author xubin.
 * @create 2017-02-22 下午12:51
 */

@Service
@Transactional
@Slf4j
public class CartServiceImpl implements CartService {


    @Value("${redisKey.prefix.cart_info_profix}")
    private String CART_INFO_PROFIX;
    @Value("${redisKey.prefix.redis_cart_expire_time}")
    private Integer REDIS_CART_EXPIRE_TIME;
    @Value("${redisKey.prefix.item_info_profix}")
    private String ITEM_INFO_PROFIX;
    @Value("${redisKey.prefix.item_info_base_suffix}")
    private String ITEM_INFO_BASE_SUFFIX;

    @Autowired
    private JedisClient jedisClient;

    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public XbinResult addCart(Long pid, Integer pcount, String uuid) {


        String key = CART_INFO_PROFIX + uuid;
        String cartInfoString = null;
        try {
            cartInfoString = jedisClient.get(key);
        } catch (Exception e) {
            log.error("Redis出错!", e);
        }

        TbItem item = null;

        try {
            String redisItem = jedisClient.get(ITEM_INFO_PROFIX + pid + ITEM_INFO_BASE_SUFFIX);

            if (StringUtils.isNotBlank(redisItem)) {
                item = FastJsonConvert.convertJSONToObject(redisItem, TbItem.class);

            } else {
                TbItemExample example = new TbItemExample();
                TbItemExample.Criteria criteria = example.createCriteria();

                criteria.andIdEqualTo(pid);

                List<TbItem> itemList = itemMapper.selectByExample(example);

                if (itemList != null && itemList.size() > 0) {
                    item = itemList.get(0);
                } else {
                    return XbinResult.build(500, "商品查询不到!");
                }
            }

        } catch (Exception e) {
            log.error("Redis出错!", e);
        }

            CartInfo cartInfo = new CartInfo();

            cartInfo.setId(item.getId());
            cartInfo.setName(item.getTitle());
            String[] split = item.getImage().split(",");
            cartInfo.setImageUrl(split[0]);
            cartInfo.setColour("黑色");
            cartInfo.setNum(pcount);
            cartInfo.setPrice(item.getPrice());
            cartInfo.setSize("32GB");

            if (StringUtils.isBlank(cartInfoString)) {

                ArrayList<CartInfo> cartInfos = new ArrayList<>();

                cartInfos.add(cartInfo);

                log.debug("第一次保存商品到Redis uuid:" + uuid);

                try {
                    jedisClient.set(key, FastJsonConvert.convertObjectToJSON(cartInfos));
                    jedisClient.expire(key, REDIS_CART_EXPIRE_TIME);
                } catch (Exception e) {
                    log.error("Redis出错!", e);
                }

                return XbinResult.build(200, "ok", cartInfo);

            } else {
                List<CartInfo> list = FastJsonConvert.convertJSONToArray(cartInfoString, CartInfo.class);
                if (list != null && list.size() > 0) {
                    boolean flag = true;
                    for (int i = 0; i < list.size(); i++) {
                        CartInfo Info = list.get(i);
                        if (Info.getId().equals(item.getId())) {
                            Info.setNum(Info.getNum() + pcount);
                            list.remove(i);
                            list.add(Info);
                            flag = false;

                            log.debug("商品已经存在数量加" + pcount + "个 uuid:" + uuid);
                        }
                    }
                    if (flag) {
                        list.add(cartInfo);
                        log.debug("商品不存在数量为" + pcount + "个 uuid:" + uuid);
                    }
                }

                log.debug("商品添加完成 购物车" + list.size() + "件商品 uuid:" + uuid);

                try {
                    jedisClient.set(key, FastJsonConvert.convertObjectToJSON(list));
                    jedisClient.expire(key, REDIS_CART_EXPIRE_TIME);
                } catch (Exception e) {
                    log.error("Redis出错!", e);
                }

                return XbinResult.build(200, "ok", cartInfo);
            }
    }

    @Override
    public List<CartInfo> getCartInfoListByCookiesId(String cookieUUID) {

        String cartInfoString = jedisClient.get(CART_INFO_PROFIX + cookieUUID);

        if (StringUtils.isNotBlank(cartInfoString)) {
            List<CartInfo> cartInfos = FastJsonConvert.convertJSONToArray(cartInfoString, CartInfo.class);

            return cartInfos;
        }

        return null;
    }

    /**
     *
     * 根据商品id和数量对购物车增加商品或减少商品
     *
     * @param pid       商品id
     * @param pcount    增加数量
     * @param type      1 增加 2 减少
     * @param index     商品位置   ps:用于直接定位商品 不用遍历整个购物车
     * @return
     */
    @Override
    public XbinResult decreOrIncre(Long pid, Integer pcount, Integer type, Integer index, String cookieUUID) {

        String key = CART_INFO_PROFIX + cookieUUID;

        List<CartInfo> cartInfoList = getCartInfoListByCookiesId(cookieUUID);
        if (cartInfoList == null || cartInfoList.size() == 0) {
            return XbinResult.build(400, "购物车没有此商品 请不要非法操作!");
        }

        CartInfo cartInfo = cartInfoList.get(index);

        if (type == 1) {
            cartInfo.setNum(cartInfo.getNum() + pcount);
        } else {
            cartInfo.setNum(cartInfo.getNum() - pcount);
        }
        //cartInfoList.remove(index);
        //cartInfoList.add(index, cartInfo);
        jedisClient.set(key, FastJsonConvert.convertObjectToJSON(cartInfoList));
        jedisClient.expire(key,REDIS_CART_EXPIRE_TIME);

        return XbinResult.ok();
    }


}
