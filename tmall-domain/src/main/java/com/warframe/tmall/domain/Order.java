package com.warframe.tmall.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by warframe on 2017/6/2.
 * 一个订单有多个订单项
 * 一个订单项只对应一个点单
 * 一个订单属于一个用户
 */
@Data
public class Order {
    private int id;

    private int uid;

    private User user;
    private List<OrderItem> orderItems;

    private String orderCode;
    private String address;
    private String userMessage;
    private String status;
    private String mobile;

    private Date createDate;
    private Date payDate;
    private Date deliveryDate;
    private Date confirmDate;

    private String post;
    private String receiver;


    //数量和总价格后期添加
    private int totalNumber;
    private float totalPrice;

    //获取状态码
    public String getStatusDesc() {
        String desc = "未知";
        switch (status) {
            case "waitPay":
                desc = "待付款";
                break;
            case "waitDelivery":
                desc = "待发货";
                break;
            case "waitConfirm":
                desc = "待收货";
                break;
            case "waitReview":
                desc = "等评价";
                break;
            case "finish":
                desc = "完成";
                break;
            case "delete":
                desc = "刪除";
                break;
            default:
                desc = "未知";
        }
        return desc;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", uid=" + uid +
                ", user=" + user +
                ", orderItems=" + orderItems +
                ", orderCode='" + orderCode + '\'' +
                ", address='" + address + '\'' +
                ", userMessage='" + userMessage + '\'' +
                ", status='" + status + '\'' +
                ", mobile='" + mobile + '\'' +
                ", createDate=" + createDate +
                ", payDate=" + payDate +
                ", deliveryDate=" + deliveryDate +
                ", confirmDate=" + confirmDate +
                ", post='" + post + '\'' +
                ", receiver='" + receiver + '\'' +
                ", totalNumber=" + totalNumber +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
