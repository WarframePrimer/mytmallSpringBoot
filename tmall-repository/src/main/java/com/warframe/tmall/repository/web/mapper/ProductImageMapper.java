package com.warframe.tmall.repository.web.mapper;

import com.warframe.tmall.domain.web.ProductImage;

public interface ProductImageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductImage record);

    int insertSelective(ProductImage record);

    ProductImage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductImage record);

    int updateByPrimaryKey(ProductImage record);
}