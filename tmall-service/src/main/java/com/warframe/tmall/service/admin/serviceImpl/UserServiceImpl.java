package com.warframe.tmall.service.admin.serviceImpl;

import com.warframe.tmall.domain.admin.Permission;
import com.warframe.tmall.domain.admin.Role;
import com.warframe.tmall.domain.admin.User;
import com.warframe.tmall.repository.admin.mapper.PermissionMapper;
import com.warframe.tmall.repository.admin.mapper.RolePermissionMapMapper;
import com.warframe.tmall.repository.admin.mapper.UserMapper;
import com.warframe.tmall.service.admin.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yaojiabin
 * @Description'
 * @date 2018-04-18 16:09
 */
@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RolePermissionMapMapper rolePermissionMapMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public Role getRoleByUserId(Long userId) {
        return userMapper.getRoleByUserId(userId);
    }

    @Override
    public List<String> getPerms(Long userId) {

        List<String> perms = new ArrayList<>();
        Role role = getRoleByUserId(userId);

        List<Long> permissionIds = rolePermissionMapMapper.getPermissionIdsByRoleId(role.getId());
        for (Long permissionId : permissionIds) {
            Permission permission = permissionMapper.selectByPrimaryKey(permissionId);
            if (StringUtils.isNoneBlank(permission.getPermissionAction())) {
                perms.add(permission.getPermissionName());
            }
        }

        return perms;
    }

    @Override
    public User selectByUserName(String username) {
        return userMapper.selectByUserName(username);
    }
}
