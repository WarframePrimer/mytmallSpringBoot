package com.warframe.tmall.domain;

import lombok.Data;

/**
 * Created by warframe on 2017/6/2.
 * 一个分类对应多个属性
 * 一个属性属于分类
 */
@Data
public class Property {

    private int id;
    private String name;
    private Category category;

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
