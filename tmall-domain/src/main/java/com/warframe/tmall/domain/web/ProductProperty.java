package com.warframe.tmall.domain.web;

import lombok.Data;

import java.util.Date;

/**
 * Created by warframe on 2017/6/2.
 * <p>
 * 商品属性
 */
@Data
public class ProductProperty {

    private Long id;
    private Long productId;
    private Long categoryId;
    private Long propertyId;
    private String value;
    private Date createTime;
    private Date updateTime;

    @Override
    public String toString() {
        return "ProductProperty{" +
                "id=" + id +
                ", productId=" + productId +
                ", categoryId=" + categoryId +
                ", propertyId=" + propertyId +
                ", value='" + value + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
