package com.warframe.tmall.domain;

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

    private int id;
    private User user;
    private Product product;
    private int number;
    private Order order;


    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", user=" + user +
                ", product=" + product +
                ", number=" + number +
                ", order=" + order +
                '}';
    }
}
