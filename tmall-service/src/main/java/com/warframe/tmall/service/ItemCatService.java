package com.warframe.tmall.service;



import com.warframe.tmall.common.pojo.ZTreeNode;
import com.warframe.tmall.domain.pojo.TbItemCat;

import java.util.List;

/**
 * Created by Exrick on 2017/8/2.
 */
public interface ItemCatService {

    TbItemCat getItemCatById(Long id);

    List<ZTreeNode> getItemCatList(int parentId);

    int addItemCat(TbItemCat tbItemCat);

    int updateItemCat(TbItemCat tbItemCat);

    void deleteItemCat(Long id);

    void deleteZTree(Long id);
}
