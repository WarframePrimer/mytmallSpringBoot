package com.warframe.tmall.domain.admin;

public class Permission {
    private Long id;

    private String permissionName;

    private String permissionAction;

    public Permission(Long id, String permissionName, String permissionAction) {
        this.id = id;
        this.permissionName = permissionName;
        this.permissionAction = permissionAction;
    }

    public Permission() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getPermissionAction() {
        return permissionAction;
    }

    public void setPermissionAction(String permissionAction) {
        this.permissionAction = permissionAction == null ? null : permissionAction.trim();
    }
}