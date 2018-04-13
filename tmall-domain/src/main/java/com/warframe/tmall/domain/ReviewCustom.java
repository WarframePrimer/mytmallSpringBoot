package com.warframe.tmall.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Author warframe[github.com/WarframePrimer]
 * @Date 2017/9/11 15:09
 */
@Data
public class ReviewCustom {
    private int id;
    private String content;
    private Date createDate;
    private String userName;
}
