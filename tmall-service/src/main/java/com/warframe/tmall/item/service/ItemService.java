package com.warframe.tmall.item.service;


import com.warframe.tmall.domain.TbItem;
import com.warframe.tmall.domain.TbItemDesc;

/**
 * 商品 Service
 *
 */

public interface ItemService {

    TbItem getItemById(Long itemId);

    TbItemDesc getItemDescById(Long itemId);

}
