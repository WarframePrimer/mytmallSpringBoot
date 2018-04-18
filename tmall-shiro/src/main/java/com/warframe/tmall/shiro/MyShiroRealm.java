package com.warframe.tmall.shiro;

import com.warframe.tmall.domain.admin.Permission;
import com.warframe.tmall.domain.admin.Role;
import com.warframe.tmall.domain.admin.User;
import com.warframe.tmall.repository.admin.mapper.PermissionMapper;
import com.warframe.tmall.repository.admin.mapper.RoleMapper;
import com.warframe.tmall.repository.admin.mapper.RolePermissionMapMapper;
import com.warframe.tmall.repository.admin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @author yaojiabin
 * @Description'
 * @date 2018-04-18 13:55
 */
@Slf4j
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RolePermissionMapMapper rolePermissionMapMapper;


    /**
     * 授权用户权限
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("doGetAuthorizationInfo+" + principalCollection.toString());

        User user = userMapper.selectByUserName((String) principalCollection.getPrimaryPrincipal());

        //把principals放session中 key=userId value=principals
        SecurityUtils.getSubject().getSession().setAttribute(String.valueOf(user.getId()), SecurityUtils.getSubject().getPrincipals());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //赋予角色
        Role role = userMapper.getRoleByUserId(user.getId());
        info.addRole(role.getRoleName());

        //赋予权限
        List<Long> permissionIds = rolePermissionMapMapper.getPermissionIdsByRoleId(role.getId());
        for (Long permissionId : permissionIds) {
            Permission permission = permissionMapper.selectByPrimaryKey(permissionId);
            if (StringUtils.isNoneBlank(permission.getPermissionAction())) {
                info.addStringPermission(permission.getPermissionName());
            }
        }

        return info;
    }

    /**
     * 验证用户身份
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        log.info("doGetAuthenticationInfo +" + authenticationToken.toString());

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = String.valueOf(token.getPassword());

        User user = userMapper.selectByUserName(username);
        if (user != null) {
//            byte[] salt = Encodes.decodeHex(user.getSalt());
//            ShiroUser shiroUser=new ShiroUser(user.getId(), user.getLoginName(), user.getName());
            //设置用户session
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("user", user);
            return new SimpleAuthenticationInfo(username, user.getPassword(), getName());
        } else {
            return null;
        }
    }
}
