package com.warframe.tmall.domain.web;

import lombok.Data;

import java.util.Date;

/**
 * @author yaojiabin
 * @Description'
 * @date 2018-04-16 14:08
 */
@Data
public class CarouselImage {
    private Long id;
    private String imageUrl;
    private String link;
    private Date createTime;
    private Date updateTime;

    @Override
    public String toString() {
        return "tmallCarouselImage{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", link='" + link + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
