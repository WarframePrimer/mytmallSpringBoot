package com.warframe.tmall.domain.web;

public class Category {
    private Long id;

    private String categoryName;

    private Integer status;

    private String icon;

    public Category(Long id, String categoryName, Integer status, String icon) {
        this.id = id;
        this.categoryName = categoryName;
        this.status = status;
        this.icon = icon;
    }

    public Category() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }
}