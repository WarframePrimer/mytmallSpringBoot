package com.warframe.tmall.domain.web;

import lombok.Data;

/**
 * Created by warframe on 2017/6/2.
 * 一个分类对应多个属性
 * 一个属性属于分类
 */
@Data
public class Property {

    private Long id;
    private Long categoryId;
    private String propertyName;
    private String status;//1 正常 2 下架

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", propertyName='" + propertyName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
