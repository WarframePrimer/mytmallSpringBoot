package com.warframe.tmall.domain.web;

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

    private Long id;
    private Long customerId;
    private String orderCode;
    private Long customerAddressId;
    private String orderReceiver;
    private String mobile;
    private String userMessage;
    private Float orderPrice;
    private String orderStatus;
    private String isComment;

    private Date createTime;
    private Date payTime;
    private Date deliveryTime;
    private Date confirmTime;

    //数量和总价格后期添加
//    private int totalNumber;
//    private float totalPrice;

    //获取状态码
    public String getStatusDesc() {
        String desc = "未知";
        switch (orderStatus) {
            case "0":
                desc = "待付款";
                break;
            case "1":
                desc = "待发货";
                break;
            case "2":
                desc = "待收货";
                break;
            case "3":
                desc = "等评价";
                break;
            case "4":
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
                ", customerId=" + customerId +
                ", orderCode='" + orderCode + '\'' +
                ", customerAddressId=" + customerAddressId +
                ", orderReceiver='" + orderReceiver + '\'' +
                ", mobile='" + mobile + '\'' +
                ", userMessage='" + userMessage + '\'' +
                ", orderPrice=" + orderPrice +
                ", orderStatus='" + orderStatus + '\'' +
                ", isComment='" + isComment + '\'' +
                ", createTime=" + createTime +
                ", payTime=" + payTime +
                ", deliveryTime=" + deliveryTime +
                ", confirmTime=" + confirmTime +
                '}';
    }
}
