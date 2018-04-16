package com.warframe.tmall.domain.web;

import lombok.Data;

import java.util.Date;

/**
 * Created by warframe on 2017/6/2.
 * 一个商品有多张图片，一个图片只对应一个商品
 *
 * 图片属于哪一个产品
 */
@Data
public class ProductImage {

    private Long id;
    private Long productId;
    private String imageUrl;
    private String imageType;
    private Date createTime;
    private Date updateTime;

    @Override
    public String toString() {
        return "ProductImage{" +
                "id=" + id +
                ", productId=" + productId +
                ", imageUrl='" + imageUrl + '\'' +
                ", imageType='" + imageType + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
