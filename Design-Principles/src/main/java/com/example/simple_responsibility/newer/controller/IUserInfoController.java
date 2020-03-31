package com.example.simple_responsibility.newer.controller;

import com.example.simple_responsibility.newer.domain.UserInfo;
import com.example.simple_responsibility.newer.service.impl.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IUserInfoController {

    @Autowired
    private UserInfoServiceImpl iUserInfoService;

    @RequestMapping({"/", "/index", "/index.html"})
    public String toIndex(Model model) {
        model.addAttribute("msg", "This is Simple Responsibility Principle");
        return "index";
    }

    public String getUserName(UserInfo userInfo) {
        return iUserInfoService.getUserName();
    }

    public void setPassword(UserInfo userInfo) {
        iUserInfoService.setPassword(userInfo.getPassword());
    }

    public void deleteUserById(UserInfo userInfo) {
        iUserInfoService.deleteUserById(userInfo.getId());
    }
}
