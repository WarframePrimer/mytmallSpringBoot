package com.warframe.tmall.service.serviceImpl;

import com.warframe.tmall.domain.web.Customer;
import com.warframe.tmall.repository.web.mapper.CustomerMapper;
import com.warframe.tmall.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yaojiabin
 * @Description'
 * @date 2018-04-17 17:01
 */

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public Customer getCustomerById(Long id) {
        return (Customer) customerMapper.getById(id);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerMapper.save(customer);
    }

    @Override
    public int getTotalNumber() {
        return customerMapper.getTotalNumber();
    }

    @Override
    public List<Customer> list(int start, int count) {
        return customerMapper.findByPage(null, start, count);
    }

    @Override
    public boolean isExist(String name) {
        return customerMapper.isExist(name);
    }

    @Override
    public boolean checkCustomer(String name, String password) {
        return customerMapper.checkCustomer(name, password);
    }

    @Override
    public Customer getByCustomerName(String name) {
        return customerMapper.getCustomerByName(name);
    }

    @Override
    public boolean registerCustomer(Customer customer) {
        boolean flag = false;
        if (!customerMapper.isExist(customer.getCustomerName())) {
            //用户名尚未被注册，进行新增操作
            customerMapper.save(customer);
            flag = true;
        }
        return flag;
    }
}
