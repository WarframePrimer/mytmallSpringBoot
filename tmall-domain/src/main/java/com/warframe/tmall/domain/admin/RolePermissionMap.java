package com.warframe.tmall.domain.admin;

import lombok.Data;

/**
 * @author yaojiabin
 * @Description'
 * @date 2018-04-16 13:54
 */
@Data
public class RolePermissionMap {
    private Long id;
    private Long roleId;
    private Long permissionId;

    @Override
    public String toString() {
        return "RolePermissionMap{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", permissionId=" + permissionId +
                '}';
    }
}
