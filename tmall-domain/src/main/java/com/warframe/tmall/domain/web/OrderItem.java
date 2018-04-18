package com.warframe.tmall.domain.web;

public class OrderItem {
    private Long id;

    private Long orderId;

    private Long productId;

    private Integer customerId;

    private Integer number;

    private String isComment;

    public OrderItem(Long id, Long orderId, Long productId, Integer customerId, Integer number, String isComment) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.customerId = customerId;
        this.number = number;
        this.isComment = isComment;
    }

    public OrderItem() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getIsComment() {
        return isComment;
    }

    public void setIsComment(String isComment) {
        this.isComment = isComment == null ? null : isComment.trim();
    }
}