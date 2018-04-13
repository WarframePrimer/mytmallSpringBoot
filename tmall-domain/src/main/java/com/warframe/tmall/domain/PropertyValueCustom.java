package com.warframe.tmall.domain;

import lombok.Data;

/**
 * 自定义属性值实体类
 * 添加字段
 * productName
 * propertyName
 *
 * 该自定义实体类包括 propertyValue.id,propertyName,propertyValue,productName
 *
 */
@Data
public class PropertyValueCustom extends PropertyValue{

    private int productId;
    private int propertyId;
    private String productName;
    private String propertyName;

    @Override
    public String toString() {
        return "PropertyValueCustom{" +
                "productName='" + productName + '\'' +
                ", propertyName='" + propertyName + '\'' + super.toString() +
                '}';
    }
}
