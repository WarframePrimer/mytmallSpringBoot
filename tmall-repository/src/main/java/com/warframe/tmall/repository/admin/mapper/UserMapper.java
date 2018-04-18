package com.warframe.tmall.repository.admin.mapper;

import com.warframe.tmall.domain.admin.Role;
import com.warframe.tmall.domain.admin.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUserName(String userName);

    Role getRoleByUserId(Long userId);
}