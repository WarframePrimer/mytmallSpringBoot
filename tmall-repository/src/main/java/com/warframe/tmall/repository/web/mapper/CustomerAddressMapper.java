package com.warframe.tmall.repository.web.mapper;

import com.warframe.tmall.domain.web.CustomerAddress;

public interface CustomerAddressMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CustomerAddress record);

    int insertSelective(CustomerAddress record);

    CustomerAddress selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CustomerAddress record);

    int updateByPrimaryKey(CustomerAddress record);
}