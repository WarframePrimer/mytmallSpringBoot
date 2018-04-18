package com.warframe.tmall.repository.admin.mapper;

import com.warframe.tmall.domain.admin.RolePermissionMap;

public interface RolePermissionMapMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RolePermissionMap record);

    int insertSelective(RolePermissionMap record);

    RolePermissionMap selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RolePermissionMap record);

    int updateByPrimaryKey(RolePermissionMap record);
}