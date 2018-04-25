//package com.warframe.tmall.controller.cms;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.subject.Subject;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author yaojiabin
// * @Description'
// * @date 2018-04-18 15:23
// */
//
//@Slf4j
////@RestController
//public class LoginController {
//
//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public String login( @RequestParam(value = "username", required = true) String userName,
//                         @RequestParam(value = "password", required = true) String password,
//                         @RequestParam(value = "rememberMe", required = true, defaultValue = "false") boolean rememberMe){
//        log.info("=============== {} ,{},{}",userName,password,rememberMe );
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
//        token.setRememberMe(rememberMe);
//
//        try {
//            subject.login(token);
//        }catch (AuthenticationException e){
//            e.printStackTrace();
//            return "{\"msg\":\"账号或密码错误\",\"state\":\"failed\"}";
//        }
//        return "{\"Msg\":\"登陆成功\",\"state\":\"success\"}";
//    }
//
//    @RequestMapping("/")
//    public String index() {
//        return "no permission";
//    }
//}
