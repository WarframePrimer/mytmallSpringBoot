package com.warframe.tmall.service;


import com.warframe.tmall.common.pojo.AllGoodsResult;
import com.warframe.tmall.common.pojo.DataTablesResult;
import com.warframe.tmall.domain.dto.front.ProductDet;
import com.warframe.tmall.domain.dto.front.ProductHome;
import com.warframe.tmall.domain.pojo.TbContent;

public interface ContentService {

    int addContent(TbContent content);

    DataTablesResult getContentListByCid(Long cid);

    int deleteContent(Long id);

    int updateContent(TbContent content);

    TbContent getContentById(Long id);

    ProductHome getProductHome();

    ProductDet getProductDet(Long id);

    AllGoodsResult getAllProduct(int page, int size, String sort, int priceGt, int priceLte);
}
