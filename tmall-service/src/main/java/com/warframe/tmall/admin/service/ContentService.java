package com.warframe.tmall.admin.service;

import com.warframe.tmall.common.pojo.XbinResult;
import com.warframe.tmall.domain.TbCategorySecondary;

import java.util.Map;

/**
 * @Author warframe[github.com/WarframePrimer]
 * @Date 2018/4/23 21:53
 */
public interface ContentService {


    Map<String, Object> getCategoryList(Integer sEcho, Integer iDisplayStart, Integer iDisplayLength);

    XbinResult saveCategory(String id, String name, Integer sort_order);

    Map<String,Object> getCategorySecondaryList(Integer sEcho, Integer iDisplayStart, Integer iDisplayLength);

    Map<String,Object> getSearchCategorySecondaryList(String sSearch, Integer sEcho, Integer iDisplayStart, Integer iDisplayLength);

    XbinResult saveCategorySecondary(TbCategorySecondary categorySecondary);
}

