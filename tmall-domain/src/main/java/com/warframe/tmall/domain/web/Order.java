package com.warframe.tmall.domain.web;

import java.util.Date;

public class Order {
    private Long id;

    private Integer customerId;

    private String ordercode;

    private Long customerAddressId;

    private String orderReceiver;

    private String mobile;

    private String usermessage;

    private Float orderPrice;

    private String orderStatus;

    private String isComment;

    private Date createTime;

    private Date payTime;

    private Date deliveryTime;

    private Date confirmTime;

    public Order(Long id, Integer customerId, String ordercode, Long customerAddressId, String orderReceiver, String mobile, String usermessage, Float orderPrice, String orderStatus, String isComment, Date createTime, Date payTime, Date deliveryTime, Date confirmTime) {
        this.id = id;
        this.customerId = customerId;
        this.ordercode = ordercode;
        this.customerAddressId = customerAddressId;
        this.orderReceiver = orderReceiver;
        this.mobile = mobile;
        this.usermessage = usermessage;
        this.orderPrice = orderPrice;
        this.orderStatus = orderStatus;
        this.isComment = isComment;
        this.createTime = createTime;
        this.payTime = payTime;
        this.deliveryTime = deliveryTime;
        this.confirmTime = confirmTime;
    }

    public Order() {
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

    public String getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode == null ? null : ordercode.trim();
    }

    public Long getCustomerAddressId() {
        return customerAddressId;
    }

    public void setCustomerAddressId(Long customerAddressId) {
        this.customerAddressId = customerAddressId;
    }

    public String getOrderReceiver() {
        return orderReceiver;
    }

    public void setOrderReceiver(String orderReceiver) {
        this.orderReceiver = orderReceiver == null ? null : orderReceiver.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getUsermessage() {
        return usermessage;
    }

    public void setUsermessage(String usermessage) {
        this.usermessage = usermessage == null ? null : usermessage.trim();
    }

    public Float getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Float orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getIsComment() {
        return isComment;
    }

    public void setIsComment(String isComment) {
        this.isComment = isComment == null ? null : isComment.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }
}