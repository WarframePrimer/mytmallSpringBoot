package com.warframe.tmall.repository.web.mapper;

import com.warframe.tmall.domain.web.Customer;
import com.warframe.tmall.repository.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMapper extends BaseMapper {

    boolean isExist(String name);

    boolean checkCustomer(String name,String password);

    Customer getCustomerByName(String name);
}
