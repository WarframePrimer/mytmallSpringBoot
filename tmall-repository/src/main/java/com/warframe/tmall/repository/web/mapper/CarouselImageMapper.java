package com.warframe.tmall.repository.web.mapper;

import com.warframe.tmall.domain.web.CarouselImage;

public interface CarouselImageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CarouselImage record);

    int insertSelective(CarouselImage record);

    CarouselImage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CarouselImage record);

    int updateByPrimaryKey(CarouselImage record);
}