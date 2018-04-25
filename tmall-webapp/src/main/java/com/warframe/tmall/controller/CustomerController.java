//package com.warframe.tmall.controller;
//
//import com.warframe.tmall.domain.web.Customer;
//import com.warframe.tmall.service.web.ICustomerService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.util.HtmlUtils;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author yaojiabin
// * @Description'
// * @date 2018-04-17 14:52
// */
//
//@Slf4j
//@Controller
//@RequestMapping("/customer")
//public class CustomerController {
//
//    @Autowired
//    private ICustomerService customerService;
//
////    @Autowired
////    private IOrderItemService orderItemService;
//
//
//    //注册
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public ModelAndView registerUser(@RequestParam("name") String name,
//                                     @RequestParam("password") String password) {
//        ModelAndView modelAndView = new ModelAndView("frontPage/register");
////        name = StringUtil.toUTF(name);
//////        password = StringUtil.toUTF(password);
//        //对字符串进行转义，防止恶意注册
//        name = HtmlUtils.htmlEscape(name);
//        password = HtmlUtils.htmlEscape(password);
//        log.info("CustomerController:register name={},password={}", name, password);
//
//        Customer customer = new Customer();
//        customer.setCustomerName(name);
//        customer.setPassword(password);
//
//        if (customerService.registerCustomer(customer)) {
//            modelAndView.addObject("msg", "注册成功，请返回主页进行登录。");
//        } else {
//            //用户名已经被注册！！
//            modelAndView.addObject("msg", "用户名已被注册！！请重新注册。");
//        }
//
//        return modelAndView;
//    }
//
//
//    //检查用户是否登陆，只需要检查session中是否有userName这个属性即可
//    @RequestMapping("/checkLogin")
//    @ResponseBody
//    //将返回的map对象转换为json对象
//    public Map<String, String> checkLogin(HttpServletRequest request) {
//        Customer customer = (Customer) request.getSession().getAttribute("customer");
//        Map<String, String> map = new HashMap<>();
//        if (null != customer)
//            //表示用户已登录
//            map.put("msg", "success");
//            //表示为登陆
//        else map.put("msg", "fail");
//
//        return map;
//    }
//
//    //loginAjax
//    @RequestMapping("/loginAjax")
//    @ResponseBody
//    public Map<String, String> loginAjax(@RequestParam("name") String name,
//                                         @RequestParam("password") String password,
//                                         HttpServletRequest request) {
//
//
//        Map<String, String> map = new HashMap<>();
//
//        log.info("CustomerController:loginAjax  customerName={},password={}", name, password);
//
//        if (customerService.isExist(name)) {
//
//            //存在该用户名，进行下一步判断
//            //logger.info("存在该用户");
//            if (customerService.checkCustomer(name, password)) {
//                //用户名和密码都正确，登录成功
////                sessionSetUserAndCartItemNumber(request, name);
//                map.put("msg", "success");
//            } else {
//                //密码错误
//                map.put("msg", "密码错误!");
//            }
//        } else {
//            //用户名不存在
//            map.put("msg", "用户名不存在!!");
//        }
//
//        return map;
//    }
//
//    //退出登录
//    @RequestMapping("/logout")
//    public ModelAndView logout(HttpServletRequest request) {
//        //将登陆的用户名和购物车数量从session中remove
//        request.getSession().removeAttribute("customer");
//        request.getSession().removeAttribute("cartItemNumber");
//        ModelAndView modelAndView = new ModelAndView("redirect:home");
//        return modelAndView;
//    }
//
//
////    public void sessionSetUserAndCartItemNumber(HttpServletRequest request, String customerName) {
////        Customer customer = customerService.getByCustomerName(customerName);
////        request.getSession().setAttribute("customer", customer);
////        int cartItemNumber = orderItemService.getCartItemNumber(customer.getId());
////        request.getSession().setAttribute("cartItemNumber", cartItemNumber);
////    }
//}
