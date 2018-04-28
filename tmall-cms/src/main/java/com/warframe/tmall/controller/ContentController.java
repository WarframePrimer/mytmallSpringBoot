package com.warframe.tmall.controller;

import com.warframe.tmall.common.pojo.DataTablesResult;
import com.warframe.tmall.common.pojo.Result;
import com.warframe.tmall.common.utils.ResultUtil;
import com.warframe.tmall.domain.pojo.TbContent;
import com.warframe.tmall.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping(value = "/content/list/{cid}",method = RequestMethod.GET)
    public DataTablesResult getContentByCid(@PathVariable Long cid){

        DataTablesResult result=contentService.getContentListByCid(cid);
        return result;
    }

    @RequestMapping(value = "/content/add",method = RequestMethod.POST)
    public Result<Object> addContent(@ModelAttribute TbContent tbContent){

        contentService.addContent(tbContent);
        return new ResultUtil<Object>().setData(null);
    }

    @RequestMapping(value = "/content/update",method = RequestMethod.POST)
    public Result<Object> updateContent(@ModelAttribute TbContent tbContent){

        contentService.updateContent(tbContent);
        return new ResultUtil<Object>().setData(null);
    }

    @RequestMapping(value = "/content/del/{id}",method = RequestMethod.DELETE)
    public Result<Object> addContent(@PathVariable Long id){

        contentService.deleteContent(id);
        return new ResultUtil<Object>().setData(null);
    }
}
