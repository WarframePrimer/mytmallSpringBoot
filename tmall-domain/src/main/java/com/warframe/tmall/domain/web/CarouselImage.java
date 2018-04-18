package com.warframe.tmall.domain.web;

import java.util.Date;

public class CarouselImage {
    private Long id;

    private String imageUrl;

    private String link;

    private Date createTime;

    private Date updateTime;

    public CarouselImage(Long id, String imageUrl, String link, Date createTime, Date updateTime) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.link = link;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public CarouselImage() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}