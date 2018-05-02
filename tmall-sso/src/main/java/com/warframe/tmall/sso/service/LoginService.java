package com.warframe.tmall.sso.service;


import com.warframe.tmall.domain.dto.front.Member;

public interface LoginService {

    Member userLogin(String username, String password);

    Member getUserByToken(String token);

    int logout(String token);
}
