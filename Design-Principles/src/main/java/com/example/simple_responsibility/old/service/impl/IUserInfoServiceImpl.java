package com.example.simple_responsibility.old.service.impl;

import com.example.simple_responsibility.old.service.IUserInfoService;
import org.springframework.stereotype.Service;

@Service
public class IUserInfoServiceImpl implements IUserInfoService {
    @Override
    public void setUserId(String userId) {

    }

    @Override
    public String getUserId() {
        return this.getUserId();
    }

    @Override
    public void setPassword(String password) {

    }

    @Override
    public String getPassword() {
        return this.getPassword();
    }

    @Override
    public void setUserName(String userName) {

    }

    @Override
    public String getUserName() {
        return this.getUserName();
    }

    @Override
    public boolean changePassword(String password) {
        return false;
    }

    @Override
    public boolean deleteUser() {
        return false;
    }

    @Override
    public boolean addRole(int roleId) {
        return false;
    }
}
