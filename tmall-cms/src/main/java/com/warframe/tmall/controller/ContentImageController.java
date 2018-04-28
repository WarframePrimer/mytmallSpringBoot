package com.warframe.tmall.controller;


import com.warframe.tmall.common.pojo.DataTablesResult;
import com.warframe.tmall.common.pojo.Result;
import com.warframe.tmall.common.utils.ResultUtil;
import com.warframe.tmall.domain.pojo.TbImage;
import com.warframe.tmall.service.ContentImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentImageController {

    @Autowired
    private ContentImageService contentImageService;

    @RequestMapping(value = "/image/list",method = RequestMethod.GET)
    public DataTablesResult getContentImage(){

        DataTablesResult result=contentImageService.getContentImage();
        return result;
    }

    @RequestMapping(value = "/image/update",method = RequestMethod.POST)
    public Result<Object> updateContentImage(@ModelAttribute TbImage tbImage){

        contentImageService.updateContentImage(tbImage);
        return new ResultUtil<Object>().setData(null);
    }
}
