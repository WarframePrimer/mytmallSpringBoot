package com.warframe.tmall.domain.web;


import lombok.Data;

import java.util.Date;

/**
 * Created by warframe on 2017/6/2.
 */
@Data
public class Customer {

    private Long id;
    private String customerName;
    private String password;
    private Date createTime;
    private Date updateTime;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
