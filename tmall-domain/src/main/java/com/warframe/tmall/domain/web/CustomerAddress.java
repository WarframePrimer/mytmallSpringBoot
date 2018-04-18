package com.warframe.tmall.domain.web;

public class CustomerAddress {
    private Long id;

    private Integer customerId;

    private String address;

    private String postalcode;

    private String addressType;

    public CustomerAddress(Long id, Integer customerId, String address, String postalcode, String addressType) {
        this.id = id;
        this.customerId = customerId;
        this.address = address;
        this.postalcode = postalcode;
        this.addressType = addressType;
    }

    public CustomerAddress() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode == null ? null : postalcode.trim();
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType == null ? null : addressType.trim();
    }
}