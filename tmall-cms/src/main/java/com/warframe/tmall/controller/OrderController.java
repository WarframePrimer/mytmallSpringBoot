package com.warframe.tmall.controller;


import com.warframe.tmall.common.pojo.DataTablesResult;
import com.warframe.tmall.common.pojo.Result;
import com.warframe.tmall.common.utils.ResultUtil;
import com.warframe.tmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order/list",method = RequestMethod.GET)
    public DataTablesResult getOrderList(){

        DataTablesResult result=orderService.getOrderList();
        return result;
    }

    @RequestMapping(value = "/order/count",method = RequestMethod.GET)
    public Result<Object> getOrderCount(){

        Long result=orderService.countOrder();
        return new ResultUtil<Object>().setData(result);
    }

    @RequestMapping(value = "/order/del/{id}",method = RequestMethod.DELETE)
    public Result<Object> getUserInfo(@PathVariable String id){

        orderService.deleteOrder(id);
        return new ResultUtil<Object>().setData(null);
    }
}
