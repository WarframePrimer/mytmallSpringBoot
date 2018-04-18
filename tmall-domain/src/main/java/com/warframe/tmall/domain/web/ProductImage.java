package com.warframe.tmall.domain.web;

import java.util.Date;

public class ProductImage {
    private Long id;

    private Long productId;

    private String imageUrl;

    private String imageType;

    private Date createTime;

    private Date updateTime;

    public ProductImage(Long id, Long productId, String imageUrl, String imageType, Date createTime, Date updateTime) {
        this.id = id;
        this.productId = productId;
        this.imageUrl = imageUrl;
        this.imageType = imageType;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ProductImage() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType == null ? null : imageType.trim();
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