package com.warframe.tmall.repository.web.mapper;

import com.warframe.tmall.domain.web.ProductProperty;

public interface ProductPropertyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductProperty record);

    int insertSelective(ProductProperty record);

    ProductProperty selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductProperty record);

    int updateByPrimaryKey(ProductProperty record);
}