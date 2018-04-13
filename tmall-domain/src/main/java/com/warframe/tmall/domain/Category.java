package com.warframe.tmall.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by warframe on 2017/6/2.
 */

@Data
public class Category {
    private int id;
    private String name;

    private List<Product> products;

    //这个的作用在后面会出现后面的商品分类展示中需要将每一分类的商品进行按行展示
    private List<List<Product>> productsByRow;

    //productByRows属性是根据List<Product>来进行设置的，每8个产品放入一个list，在把这个list放到List<List<Product>>中
    public List<List<Product>> createProductsByRows(List<Product> products){
        int productNumberEachRow = 8;

        List<List<Product>> productsByRow = new ArrayList<>();
        for(int i = 0;i<products.size();i+=productNumberEachRow){
            int size = i+productNumberEachRow;
            size = size>products.size()?products.size():size;
            List<Product> productsOfEachRow = products.subList(i,size);
            productsByRow.add(productsOfEachRow);
        }

        return productsByRow;
    }


    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}
