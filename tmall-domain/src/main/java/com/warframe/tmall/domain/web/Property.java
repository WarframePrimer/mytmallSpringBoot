package com.warframe.tmall.domain.web;

public class Property {
    private Long id;

    private Long categoryId;

    private String propertyName;

    private Integer status;

    public Property(Long id, Long categoryId, String propertyName, Integer status) {
        this.id = id;
        this.categoryId = categoryId;
        this.propertyName = propertyName;
        this.status = status;
    }

    public Property() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName == null ? null : propertyName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}