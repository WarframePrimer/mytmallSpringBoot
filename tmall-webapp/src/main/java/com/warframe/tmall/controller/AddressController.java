package com.warframe.tmall.controller;


import com.warframe.tmall.common.pojo.Result;
import com.warframe.tmall.common.utils.ResultUtil;
import com.warframe.tmall.domain.pojo.TbAddress;
import com.warframe.tmall.sso.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/member/addressList", method = RequestMethod.POST)
    public Result<List<TbAddress>> addressList(@RequestBody TbAddress tbAddress) {

        List<TbAddress> list = addressService.getAddressList(tbAddress.getUserId());
        return new ResultUtil<List<TbAddress>>().setData(list);
    }

    @RequestMapping(value = "/member/address", method = RequestMethod.POST)
    public Result<TbAddress> address(@RequestBody TbAddress tbAddress) {

        TbAddress address = addressService.getAddress(tbAddress.getAddressId());
        return new ResultUtil<TbAddress>().setData(address);
    }

    @RequestMapping(value = "/member/addAddress", method = RequestMethod.POST)
    public Result<Object> addAddress(@RequestBody TbAddress tbAddress) {

        int result = addressService.addAddress(tbAddress);
        return new ResultUtil<Object>().setData(result);
    }

    @RequestMapping(value = "/member/updateAddress", method = RequestMethod.POST)
    public Result<Object> updateAddress(@RequestBody TbAddress tbAddress) {

        int result = addressService.updateAddress(tbAddress);
        return new ResultUtil<Object>().setData(result);
    }

    @RequestMapping(value = "/member/delAddress", method = RequestMethod.POST)
    public Result<Object> delAddress(@RequestBody TbAddress tbAddress) {

        int result = addressService.delAddress(tbAddress);
        return new ResultUtil<Object>().setData(result);
    }
}
