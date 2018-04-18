package com.warframe.tmall.service.admin;

import com.warframe.tmall.domain.admin.Role;
import com.warframe.tmall.domain.admin.User;

import java.util.List;

public interface IUserService {

    Role getRoleByUserId(Long userId);


    List<String> getPerms(Long userId);

    User selectByUserName(String username);


}
