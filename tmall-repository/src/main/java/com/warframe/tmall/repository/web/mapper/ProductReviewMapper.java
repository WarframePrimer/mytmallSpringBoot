package com.warframe.tmall.repository.web.mapper;

import com.warframe.tmall.domain.web.ProductReview;

public interface ProductReviewMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductReview record);

    int insertSelective(ProductReview record);

    ProductReview selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductReview record);

    int updateByPrimaryKey(ProductReview record);
}