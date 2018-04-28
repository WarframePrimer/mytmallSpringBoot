package com.warframe.tmall.controller;


import com.warframe.tmall.common.pojo.DataTablesResult;
import com.warframe.tmall.common.pojo.Result;
import com.warframe.tmall.common.utils.IPInfoUtil;
import com.warframe.tmall.common.utils.ResultUtil;
import com.warframe.tmall.domain.pojo.TbBase;
import com.warframe.tmall.domain.pojo.TbOrderItem;
import com.warframe.tmall.domain.pojo.TbShiroFilter;
import com.warframe.tmall.domain.pojo.TbUser;
import com.warframe.tmall.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class SystemController {

    @Autowired
    private SystemService systemService;

    @RequestMapping(value = "/sys/shiro/list",method = RequestMethod.GET)
    public DataTablesResult getShiroList(@ModelAttribute TbUser tbUser){

        DataTablesResult result=new DataTablesResult();
        List<TbShiroFilter> list=systemService.getShiroFilter();
        result.setData(list);
        result.setSuccess(true);
        return result;
    }

    @RequestMapping(value = "/sys/shiro/count",method = RequestMethod.GET)
    public Result<Object> getUserCount(){

        Long result=systemService.countShiroFilter();
        return new ResultUtil<Object>().setData(result);
    }

    @RequestMapping(value = "/sys/shiro/add",method = RequestMethod.POST)
    public Result<Object> addShiro(@ModelAttribute TbShiroFilter tbShiroFilter){

        systemService.addShiroFilter(tbShiroFilter);
        return new ResultUtil<Object>().setData(null);
    }

    @RequestMapping(value = "/sys/shiro/update",method = RequestMethod.POST)
    public Result<Object> updateShiro(@ModelAttribute TbShiroFilter tbShiroFilter){

        systemService.updateShiroFilter(tbShiroFilter);
        return new ResultUtil<Object>().setData(null);
    }

    @RequestMapping(value = "/sys/shiro/del/{id}",method = RequestMethod.DELETE)
    public Result<Object> delShiro(@PathVariable int id){

        systemService.deleteShiroFilter(id);
        return new ResultUtil<Object>().setData(null);
    }

    @RequestMapping(value = "/sys/base",method = RequestMethod.GET)
    public Result<TbBase> getBase(){

        TbBase tbBase=systemService.getBase();
        return new ResultUtil<TbBase>().setData(tbBase);
    }

    @RequestMapping(value = "/sys/base/update",method = RequestMethod.POST)
    public Result<Object> updateBase(@ModelAttribute TbBase tbBase){

        systemService.updateBase(tbBase);
        return new ResultUtil<Object>().setData(null);
    }

    @RequestMapping(value = "/sys/weekHot",method = RequestMethod.GET)
    public Result<TbOrderItem> getWeekHot(){

        TbOrderItem tbOrderItem=systemService.getWeekHot();
        return new ResultUtil<TbOrderItem>().setData(tbOrderItem);
    }

    @RequestMapping(value = "/sys/weather",method = RequestMethod.GET)
    public Result<Object> getWeather(HttpServletRequest request){

        String result= IPInfoUtil.getIpInfo(IPInfoUtil.getIpAddr(request));
        return new ResultUtil<Object>().setData(result);
    }

    @RequestMapping(value = "/sys/log",method = RequestMethod.GET)
    public DataTablesResult getLog(){

        DataTablesResult result= systemService.getLogList();
        return result;
    }

    @RequestMapping(value = "/sys/log/count",method = RequestMethod.GET)
    public Result<Object> countLog(){

        Long result=systemService.countLog();
        return new ResultUtil<Object>().setData(result);
    }

    @RequestMapping(value = "/sys/log/del/{id}",method = RequestMethod.DELETE)
    public Result<Object> delLog(@PathVariable int id){

        systemService.deleteLog(id);
        return new ResultUtil<Object>().setData(null);
    }
}
