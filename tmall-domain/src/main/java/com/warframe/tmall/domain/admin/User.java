package com.warframe.tmall.domain.admin;

import lombok.Data;

import java.util.Date;

/**
 * @author yaojiabin
 * @Description'
 * @date 2018-04-16 13:52
 */

@Data
public class User {

    private Long id;
    private String userName;
    private String password;
    private String phone;
    private String email;
    private String state;
    private String description;
    private Long roleId;
    private Date createTime;
    private Date updateTime;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", state='" + state + '\'' +
                ", description='" + description + '\'' +
                ", roleId=" + roleId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
