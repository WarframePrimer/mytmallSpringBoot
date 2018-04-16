package com.warframe.tmall.domain.web;

import lombok.Data;


/**
 * Created by warframe on 2017/6/2.
 */

@Data
public class Category {
    private Long id;
    private String categoryName;
    private String status;
    private String icon;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", status='" + status + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
