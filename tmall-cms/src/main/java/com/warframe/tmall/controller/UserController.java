package com.warframe.tmall.controller;


import com.warframe.tmall.annotation.SystemControllerLog;
import com.warframe.tmall.common.pojo.DataTablesResult;
import com.warframe.tmall.common.pojo.Result;
import com.warframe.tmall.common.utils.GeetestLib;
import com.warframe.tmall.common.utils.ResultUtil;
import com.warframe.tmall.domain.pojo.TbPermission;
import com.warframe.tmall.domain.pojo.TbRole;
import com.warframe.tmall.domain.pojo.TbUser;
import com.warframe.tmall.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    final static Logger log= LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

//    @RequestMapping(value = "/geetestInit",method = RequestMethod.GET)
//    public String geetesrInit(HttpServletRequest request){
//
//        GeetestLib gtSdk = new GeetestLib(GeetestLib.id, GeetestLib.key,GeetestLib.newfailback);
//
//        String resStr = "{}";
//
//        //自定义参数,可选择添加
//        HashMap<String, String> param = new HashMap<String, String>();
//
//        //进行验证预处理
//        int gtServerStatus = gtSdk.preProcess(param);
//
//        //将服务器状态设置到session中
//        request.getSession().setAttribute(gtSdk.gtServerStatusSessionKey, gtServerStatus);
//
//        resStr = gtSdk.getResponseStr();
//
//        return resStr;
//    }

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @SystemControllerLog(description="登录系统")
    public Result<Object> login(String username, String password,
                                HttpServletRequest request){

            Subject subject = SecurityUtils.getSubject() ;
            //MD5加密
            String md5Pass = DigestUtils.md5DigestAsHex(password.getBytes());
            UsernamePasswordToken token = new UsernamePasswordToken(username,md5Pass);
            try {
                subject.login(token);
                return new ResultUtil<Object>().setData(null);
            }catch (Exception e){
                return new ResultUtil<Object>().setErrorMsg("用户名或密码错误");
            }
    }

    @RequestMapping(value = "/user/logout",method = RequestMethod.GET)
    public Result<Object> logout(){

        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new ResultUtil<Object>().setData(null);
    }

    @RequestMapping(value = "/user/userInfo",method = RequestMethod.GET)
    public Result<TbUser> getUserInfo(){

        String username= SecurityUtils.getSubject().getPrincipal().toString();
        TbUser tbUser=userService.getUserByUsername(username);
        tbUser.setPassword(null);
        return new ResultUtil<TbUser>().setData(tbUser);
    }

    @RequestMapping(value = "/user/roleList",method = RequestMethod.GET)
    public DataTablesResult getRoleList(){

        DataTablesResult result=userService.getRoleList();
        return result;
    }

    @RequestMapping(value = "/user/getAllRoles",method = RequestMethod.GET)
    public Result<List<TbRole>> getAllRoles(){

        List<TbRole> list=userService.getAllRoles();
        return new ResultUtil<List<TbRole>>().setData(list);
    }

    @RequestMapping(value = "/user/roleName",method = RequestMethod.GET)
    public boolean roleName(String name){

        if(userService.getRoleByRoleName(name)!=null){
            return false;
        }
        return true;
    }

    @RequestMapping(value = "/user/edit/roleName/{id}",method = RequestMethod.GET)
    public boolean roleName(@PathVariable int id, String name){

        return userService.getRoleByEditName(id,name);
    }

    @RequestMapping(value = "/user/addRole",method = RequestMethod.POST)
    public Result<Object> addRole(@ModelAttribute TbRole tbRole){

        userService.addRole(tbRole);
        return new ResultUtil<Object>().setData(null);
    }

    @RequestMapping(value = "/user/updateRole",method = RequestMethod.POST)
    public Result<Object> updateRole(@ModelAttribute TbRole tbRole){

        userService.updateRole(tbRole);
        return new ResultUtil<Object>().setData(null);
    }

    @RequestMapping(value = "/user/delRole/{id}",method = RequestMethod.DELETE)
    public Result<Object> delRole(@PathVariable int id){

        int result=userService.deleteRole(id);
        if(result==1){
            return new ResultUtil<Object>().setData(null);
        }else {
            return new ResultUtil<Object>().setErrorMsg("该角色被使用中，不能删除！");
        }
    }

    @RequestMapping(value = "/user/roleCount",method = RequestMethod.GET)
    public Result<Object> getRoleCount(){

        Long result=userService.countRole();
        return new ResultUtil<Object>().setData(result);
    }

    @RequestMapping(value = "/user/permissionList",method = RequestMethod.GET)
    public DataTablesResult getPermissionList(){

        DataTablesResult result=userService.getPermissionList();
        return result;
    }

    @RequestMapping(value = "/user/addPermission",method = RequestMethod.POST)
    public Result<Object> addPermission(@ModelAttribute TbPermission tbPermission){

        userService.addPermission(tbPermission);
        return new ResultUtil<Object>().setData(null);
    }

    @RequestMapping(value = "/user/updatePermission",method = RequestMethod.POST)
    public Result<Object> updatePermission(@ModelAttribute TbPermission tbPermission){

        userService.updatePermission(tbPermission);
        return new ResultUtil<Object>().setData(null);
    }

    @RequestMapping(value = "/user/delPermission/{id}",method = RequestMethod.DELETE)
    public Result<Object> delPermission(@PathVariable int id){

        userService.deletePermission(id);
        return new ResultUtil<Object>().setData(null);
    }

    @RequestMapping(value = "/user/permissionCount",method = RequestMethod.GET)
    public Result<Object> getPermissionCount(){

        Long result=userService.countPermission();
        return new ResultUtil<Object>().setData(result);
    }

    @RequestMapping(value = "/user/userList",method = RequestMethod.GET)
    public DataTablesResult getUserList(){

        DataTablesResult result=userService.getUserList();
        return result;
    }

    @RequestMapping(value = "/user/username",method = RequestMethod.GET)
    public boolean getUserByName(String username){

        return userService.getUserByName(username);
    }

    @RequestMapping(value = "/user/phone",method = RequestMethod.GET)
    public boolean getUserByPhone(String phone){

        return userService.getUserByPhone(phone);
    }

    @RequestMapping(value = "/user/email",method = RequestMethod.GET)
    public boolean getUserByEmail(String email){

        return userService.getUserByEmail(email);
    }

    @RequestMapping(value = "/user/addUser",method = RequestMethod.POST)
    public Result<Object> addUser(@ModelAttribute TbUser tbUser){

        userService.addUser(tbUser);
        return new ResultUtil<Object>().setData(null);
    }

    @RequestMapping(value = "/user/updateUser",method = RequestMethod.POST)
    public Result<Object> updateUser(@ModelAttribute TbUser tbUser){

        userService.updateUser(tbUser);
        return new ResultUtil<Object>().setData(null);
    }

    @RequestMapping(value = "/user/edit/username/{id}",method = RequestMethod.GET)
    public boolean getUserByEditName(@PathVariable Long id, String username){

        return userService.getUserByEditName(id,username);
    }

    @RequestMapping(value = "/user/edit/phone/{id}",method = RequestMethod.GET)
    public boolean getUserByEditPhone(@PathVariable Long id, String phone){

        return userService.getUserByEditPhone(id,phone);
    }

    @RequestMapping(value = "/user/edit/email/{id}",method = RequestMethod.GET)
    public boolean getUserByEditEmail(@PathVariable Long id, String email){

        return userService.getUserByEditEmail(id,email);
    }

    @RequestMapping(value = "/user/stop/{id}",method = RequestMethod.PUT)
    public Result<Object> stopUser(@PathVariable Long id){

        userService.changeUserState(id,0);
        return new ResultUtil<Object>().setData(null);
    }

    @RequestMapping(value = "/user/start/{id}",method = RequestMethod.PUT)
    public Result<Object> startUser(@PathVariable Long id){

        userService.changeUserState(id,1);
        return new ResultUtil<Object>().setData(null);
    }

    @RequestMapping(value = "/user/changePass",method = RequestMethod.POST)
    public Result<Object> changePass(@ModelAttribute TbUser tbUser){

        userService.changePassword(tbUser);
        return new ResultUtil<Object>().setData(null);
    }

    @RequestMapping(value = "/user/delUser/{id}",method = RequestMethod.DELETE)
    public Result<Object> delUser(@PathVariable Long id){

        userService.deleteUser(id);
        return new ResultUtil<Object>().setData(null);
    }

    @RequestMapping(value = "/user/userCount",method = RequestMethod.GET)
    public Result<Object> getUserCount(){

        Long result=userService.countUser();
        return new ResultUtil<Object>().setData(result);
    }
}
