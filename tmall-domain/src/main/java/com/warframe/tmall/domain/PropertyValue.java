package com.warframe.tmall.domain;

import lombok.Data;

/**
 * Created by warframe on 2017/6/2.
 * <p>
 * 哪个商品的哪个属性
 */
@Data
public class PropertyValue {
    private int id;
    private String value;
    private Product product;

    private Property property;

    @Override
    public String toString() {
        return "PropertyValue{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
