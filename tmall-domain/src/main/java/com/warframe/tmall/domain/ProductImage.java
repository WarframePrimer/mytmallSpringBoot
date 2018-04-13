package com.warframe.tmall.domain;

import lombok.Data;

/**
 * Created by warframe on 2017/6/2.
 * 一个商品有多张图片，一个图片只对应一个商品
 *
 * 图片属于哪一个产品
 */
@Data
public class ProductImage {

    private int id;
    private Product product;

    //这张图片属于什么类型的是详情中还是缩略图等
    private String type;

}
