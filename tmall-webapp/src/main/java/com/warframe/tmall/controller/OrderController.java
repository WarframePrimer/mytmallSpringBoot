package com.warframe.tmall.controller;


import com.warframe.tmall.common.pojo.Result;
import com.warframe.tmall.common.utils.ResultUtil;
import com.warframe.tmall.domain.dto.front.Order;
import com.warframe.tmall.domain.dto.front.OrderInfo;
import com.warframe.tmall.sso.service.FrontOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private FrontOrderService frontOrderService;

    @RequestMapping(value = "/member/orderList",method = RequestMethod.GET)
    public Result<List<Order>> getOrderList(String userId){

        List<Order> list= frontOrderService.getOrderList(Long.valueOf(userId));
        return new ResultUtil<List<Order>>().setData(list);
    }

    @RequestMapping(value = "/member/orderDetail",method = RequestMethod.GET)
    public Result<Order> getOrder(String orderId){

        Order order= frontOrderService.getOrder(Long.valueOf(orderId));
        return new ResultUtil<Order>().setData(order);
    }

    @RequestMapping(value = "/member/addOrder",method = RequestMethod.POST)
    public Result<Object> addOrder(@RequestBody OrderInfo orderInfo){

        Long orderId= frontOrderService.createOrder(orderInfo);
        return new ResultUtil<Object>().setData(orderId.toString());
    }

    @RequestMapping(value = "/member/cancelOrder",method = RequestMethod.POST)
    public Result<Object> cancelOrder(@RequestBody Order order){

        int result= frontOrderService.cancelOrder(order.getOrderId());
        return new ResultUtil<Object>().setData(result);
    }

    @RequestMapping(value = "/member/delOrder",method = RequestMethod.GET)
    public Result<Object> delOrder(String orderId){

        int result= frontOrderService.delOrder(Long.valueOf(orderId));
        return new ResultUtil<Object>().setData(result);
    }
}
