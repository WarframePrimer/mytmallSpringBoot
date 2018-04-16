package com.warframe.tmall.domain.web;

import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class Product {
    private Long id;
    private String productName;
    private String productTitle;
    private float productOriginalPrice;
    private float productSalePrice;
    private int productStock;
    private Long categoryId;
    private String status;
    private Date createTime;
    private Date updateTime;

    /*评价个数和销售量为什么不放在数据库中？*/
//    private int reviewCount;
//    private int saleCount;


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productTitle='" + productTitle + '\'' +
                ", productOriginalPrice=" + productOriginalPrice +
                ", productSalePrice=" + productSalePrice +
                ", productStock=" + productStock +
                ", categoryId=" + categoryId +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
