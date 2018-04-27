package com.warframe.tmall.service;


import com.warframe.tmall.common.pojo.DataTablesResult;
import com.warframe.tmall.domain.pojo.TbImage;

public interface ContentImageService {

    TbImage getContentImageById(Long id);

    DataTablesResult getContentImage();

    int updateContentImage(TbImage tbImage);
}
