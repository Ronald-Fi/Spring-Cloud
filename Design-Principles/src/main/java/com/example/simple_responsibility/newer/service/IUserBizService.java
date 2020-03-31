package com.example.simple_responsibility.newer.service;

/**
 * 业务逻辑
 */
public interface IUserBizService {

    boolean changePassword(String password);

    boolean deleteUserById(Integer userId);

    boolean addRole(int roleId);

}
