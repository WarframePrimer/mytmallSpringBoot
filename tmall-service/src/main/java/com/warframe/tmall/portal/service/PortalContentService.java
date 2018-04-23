package com.warframe.tmall.portal.service;




import com.warframe.tmall.domain.TbContent;

import java.util.List;

/**
 * 内容分类Service
 * Created by cynicism on 17/1/28.
 */
public interface PortalContentService {


    List<TbContent> getContentByCid(long bigAdIndex);
}
