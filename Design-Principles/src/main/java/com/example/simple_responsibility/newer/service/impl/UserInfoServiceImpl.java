package com.example.simple_responsibility.newer.service.impl;

import com.example.simple_responsibility.newer.service.IUserBOService;
import com.example.simple_responsibility.newer.service.IUserBizService;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements IUserBOService, IUserBizService {
    @Override
    public void setUserId(String userId) {

    }

    @Override
    public String getUserId() {
        return null;
    }

    @Override
    public void setPassword(String password) {

    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void setUserName(String userName) {

    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public boolean changePassword(String password) {
        return false;
    }

    @Override
    public boolean deleteUserById(Integer userId) {
        return false;
    }

    @Override
    public boolean addRole(int roleId) {
        return false;
    }
}
