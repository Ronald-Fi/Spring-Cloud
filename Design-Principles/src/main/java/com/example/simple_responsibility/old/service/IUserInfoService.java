package com.example.simple_responsibility.old.service;

public interface IUserInfoService {

    void setUserId(String userId);

    String getUserId();

    void setPassword(String password);

    String getPassword();

    void setUserName(String userName);

    String getUserName();

    boolean changePassword(String password);

    boolean deleteUser();

    boolean addRole(int roleId);
}
