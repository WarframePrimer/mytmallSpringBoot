package com.warframe.tmall.domain;

import lombok.Data;

/**
 * @Author warframe[github.com/WarframePrimer]
 * @Date 2017/9/13 10:24
 */
@Data
public class OrderItemCustom {
    private int id;
    private int oid;
    private int pid;
    private int uid;
    private int number;

    @Override
    public String toString() {
        return "OrderItemCustom{" +
                "id=" + id +
                ", oid=" + oid +
                ", pid=" + pid +
                ", uid=" + uid +
                ", number=" + number +
                '}';
    }



}
