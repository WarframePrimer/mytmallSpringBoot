package com.warframe.tmall.domain.web;

import lombok.Data;

import java.util.Date;

/**
 * Created by warframe on 2017/6/2.
 * 一个商品有多条评价
 * 一个评价只对应一个商品
 * 一个评价只对应一个用户
 * 一个用户有多个评价(没有这个业务需求,待定(需求：用户要查看自己的评价记录))
 */
@Data
public class ProductReview {
    private Long id;
    private Long customerId;
    private Long productId;
    private String reviewContent;
    private Date createTime;

    @Override
    public String toString() {
        return "ProductReview{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", productId=" + productId +
                ", reviewContent='" + reviewContent + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
