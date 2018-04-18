package com.warframe.tmall.controller.cms;

import com.warframe.tmall.domain.web.Customer;
import com.warframe.tmall.service.web.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yaojiabin
 * @Description'
 * @date 2018-04-17 10:51
 */

@Controller
public class HomeController {

    @Autowired
    private ICustomerService customerService;

    @RequestMapping({"/index"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping("/addCustomer")
    @ResponseBody
    public Map<String, Object> addCustomer(@RequestParam("name") String name, @RequestParam("password") String password) {
        Map<String, Object> returnMap = new HashMap<>();

        Customer customer = new Customer();
        customer.setCustomerName(name);
        customer.setPassword(password);
        try{
            customerService.addCustomer(customer);
            returnMap.put("msg","success");
//            returnMap.put("data",customerService.getCustomerById());
        }catch (Exception e){
            returnMap.put("msg",e.toString());
        }


        return returnMap;
    }
}
