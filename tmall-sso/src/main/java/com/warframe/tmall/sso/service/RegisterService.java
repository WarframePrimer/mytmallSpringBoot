package com.warframe.tmall.sso.service;


public interface RegisterService {

    boolean checkData(String param, int type);

    int register(String userName, String userPwd);
}