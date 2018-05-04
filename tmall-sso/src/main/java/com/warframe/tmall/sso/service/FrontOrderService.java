package com.warframe.tmall.sso.service;


import com.warframe.tmall.domain.dto.front.Order;
import com.warframe.tmall.domain.dto.front.OrderInfo;

import java.util.List;

public interface FrontOrderService {

    List<Order> getOrderList(Long userId);

    Order getOrder(Long orderId);

    int cancelOrder(Long orderId);

    Long createOrder(OrderInfo orderInfo);

    int delOrder(Long orderId);
}
