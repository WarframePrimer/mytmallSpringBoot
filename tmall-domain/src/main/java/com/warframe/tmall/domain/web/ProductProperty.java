package com.warframe.tmall.domain.web;

import java.util.Date;

public class ProductProperty {
    private Long id;

    private Long productId;

    private Long categoryId;

    private Long propertyId;

    private String value;

    private Date createTime;

    private Date updateTime;

    public ProductProperty(Long id, Long productId, Long categoryId, Long propertyId, String value, Date createTime, Date updateTime) {
        this.id = id;
        this.productId = productId;
        this.categoryId = categoryId;
        this.propertyId = propertyId;
        this.value = value;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ProductProperty() {
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
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