package com.warframe.tmall.domain.web;

import java.util.Date;

public class Customer {
    private Long id;

    private String customerName;

    private String password;

    private Date createTime;

    private Date updateTime;

    public Customer(Long id, String customerName, String password, Date createTime, Date updateTime) {
        this.id = id;
        this.customerName = customerName;
        this.password = password;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Customer() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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