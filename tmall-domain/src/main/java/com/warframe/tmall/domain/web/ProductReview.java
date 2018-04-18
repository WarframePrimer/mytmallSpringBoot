package com.warframe.tmall.domain.web;

import java.util.Date;

public class ProductReview {
    private Long id;

    private Integer customerId;

    private Integer productId;

    private Date createTime;

    private String reviewContent;

    public ProductReview(Long id, Integer customerId, Integer productId, Date createTime, String reviewContent) {
        this.id = id;
        this.customerId = customerId;
        this.productId = productId;
        this.createTime = createTime;
        this.reviewContent = reviewContent;
    }

    public ProductReview() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent == null ? null : reviewContent.trim();
    }
}