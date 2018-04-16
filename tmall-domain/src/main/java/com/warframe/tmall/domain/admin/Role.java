package com.warframe.tmall.domain.admin;

import lombok.Data;

/**
 * @author yaojiabin
 * @Description'
 * @date 2018-04-16 13:51
 */
@Data
public class Role {
    private Long id;
    private String roleName;
    private String description;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
