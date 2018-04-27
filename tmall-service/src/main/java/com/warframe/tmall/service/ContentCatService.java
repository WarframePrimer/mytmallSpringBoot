package com.warframe.tmall.service;



import com.warframe.tmall.common.pojo.ZTreeNode;
import com.warframe.tmall.domain.dto.ContentCatDto;
import com.warframe.tmall.domain.pojo.TbContentCategory;

import java.util.List;

public interface ContentCatService {

    TbContentCategory getContentCatById(Long id);

    List<ZTreeNode> getContentCatList(Long parentId);

    int addContentCat(ContentCatDto contentCatDto);

    int updateContentCat(ContentCatDto contentCatDto);

    int deleteContentCat(Long id);
}
