package com.warframe.tmall.controller;


import com.warframe.tmall.common.pojo.Result;
import com.warframe.tmall.common.pojo.ZTreeNode;
import com.warframe.tmall.common.utils.ResultUtil;
import com.warframe.tmall.domain.dto.ContentCatDto;
import com.warframe.tmall.domain.dto.DtoUtil;
import com.warframe.tmall.service.ContentCatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContentCatController {

    private final static Logger log= LoggerFactory.getLogger(DtoUtil.class);

    @Autowired
    private ContentCatService contentCatService;

    @RequestMapping(value = "/content/cat/list",method = RequestMethod.GET)
    public List<ZTreeNode> getContentByCid(@RequestParam(name="id", defaultValue="0") Long parentId){

        List<ZTreeNode> list=contentCatService.getContentCatList(parentId);
        return list;
    }

    @RequestMapping(value = "/content/cat/add",method = RequestMethod.POST)
    public Result<Object> addContentCategory(@ModelAttribute ContentCatDto contentCatDto){

        contentCatService.addContentCat(contentCatDto);
        return new ResultUtil<Object>().setData(null);
    }

    @RequestMapping(value = "/content/cat/update",method = RequestMethod.POST)
    public Result<Object> updateContentCategory(@ModelAttribute ContentCatDto contentCatDto){

        contentCatService.updateContentCat(contentCatDto);
        return new ResultUtil<Object>().setData(null);
    }

    @RequestMapping(value = "/content/cat/del/{id}",method = RequestMethod.DELETE)
    public Result<Object> deleteContentCategory(@PathVariable Long id){

        contentCatService.deleteContentCat(id);
        return new ResultUtil<Object>().setData(null);
    }
}
