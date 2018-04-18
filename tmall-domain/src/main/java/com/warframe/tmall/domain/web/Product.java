package com.warframe.tmall.domain.web;

import java.util.Date;

public class Product {
    private Long id;

    private String productName;

    private String productTitle;

    private Float productOriginalPrice;

    private Float productSalePrice;

    private Integer productStock;

    private Long categoryId;

    private Byte status;

    private Date createTime;

    private Date updateTime;

    public Product(Long id, String productName, String productTitle, Float productOriginalPrice, Float productSalePrice, Integer productStock, Long categoryId, Byte status, Date createTime, Date updateTime) {
        this.id = id;
        this.productName = productName;
        this.productTitle = productTitle;
        this.productOriginalPrice = productOriginalPrice;
        this.productSalePrice = productSalePrice;
        this.productStock = productStock;
        this.categoryId = categoryId;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Product() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle == null ? null : productTitle.trim();
    }

    public Float getProductOriginalPrice() {
        return productOriginalPrice;
    }

    public void setProductOriginalPrice(Float productOriginalPrice) {
        this.productOriginalPrice = productOriginalPrice;
    }

    public Float getProductSalePrice() {
        return productSalePrice;
    }

    public void setProductSalePrice(Float productSalePrice) {
        this.productSalePrice = productSalePrice;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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