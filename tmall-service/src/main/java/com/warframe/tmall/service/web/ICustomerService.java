package com.warframe.tmall.service.web;

import com.warframe.tmall.domain.web.Customer;

import java.util.List;

public interface ICustomerService {

    Customer getCustomerById(Long id);

    void addCustomer(Customer customer);

    int getTotalNumber();

    List<Customer> list(int start, int count);

    boolean isExist(String name);

    boolean checkCustomer(String name,String password);

    Customer getByCustomerName(String userName);

    boolean registerCustomer(Customer customer);
}
