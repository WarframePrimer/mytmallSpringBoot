package com.warframe.tmall.domain.web;

import lombok.Data;

/**
 * Created by warframe on 2017/6/2.
 * 一个订单项只属于一个用户
 * 一个订单项中只有一个商品
 * 一个订单中才有多个商品！！
 * 一个订单项只属于一个订单
 */
@Data
public class OrderItem {

    private Long id;
    private Long orderId;
    private Long productId;
    private Long customerId;
    private int number;
    private String isComment;

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", productId=" + productId +
                ", customerId=" + customerId +
                ", number=" + number +
                ", isComment='" + isComment + '\'' +
                '}';
    }
}
