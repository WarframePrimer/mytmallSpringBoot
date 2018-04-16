package com.warframe.tmall.domain.admin;

import lombok.Data;

/**
 * @author yaojiabin
 * @Description'
 * @date 2018-04-16 13:48
 */
@Data
public class Permission {
    private Long id;
    private String permissionName;
    private String permissionAction;

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permissionName='" + permissionName + '\'' +
                ", permissionAction='" + permissionAction + '\'' +
                '}';
    }
}
