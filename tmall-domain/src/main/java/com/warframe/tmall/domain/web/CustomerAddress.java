package com.warframe.tmall.domain.web;

import lombok.Data;

/**
 * @author yaojiabin
 * @Description'
 * @date 2018-04-16 14:01
 */

@Data
public class CustomerAddress {
    private Long id;
    private Long customerId;
    private String address;
    private String postalcode;
    private String addressType;

    @Override
    public String toString() {
        return "CustomerAddress{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", address='" + address + '\'' +
                ", postalcode='" + postalcode + '\'' +
                ", addressType='" + addressType + '\'' +
                '}';
    }
}
