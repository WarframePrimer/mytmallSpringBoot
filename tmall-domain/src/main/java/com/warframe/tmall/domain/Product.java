package com.warframe.tmall.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by warframe on 2017/6/2.
 * 分析：分类和上商品的关系属于一对多的关系
 * 即一个分类中有多个商品，而一个商品只对应一个分类
 * <p>
 * 初步构想：使用静态工厂方法，简化构建bean的成本，算了，下次再说吧@_@
 */
@Data
public class Product {
    private int id;
    private Category category;

    private String name;
    private String subTitle;
    private float originalPrice;
    private float promotePrice;
    private int stock;

    private Date createDate;

    //商品的展示图片
    private ProductImage firstProductImage;

    private List<ProductImage> productSingleImage;
    private List<ProductImage> productDetailImage;

    /*评价个数和销售量为什么不放在数据库中？*/
    private int reviewCount;
    private int saleCount;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", originalPrice=" + originalPrice +
                ", promotePrice=" + promotePrice +
                ", stock=" + stock +
                ", createDate=" + createDate +
                '}';
    }
}
