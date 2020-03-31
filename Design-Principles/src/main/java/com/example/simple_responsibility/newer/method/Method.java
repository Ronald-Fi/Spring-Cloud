package com.example.simple_responsibility.newer.method;

import com.example.simple_responsibility.newer.domain.UserInfo;

import java.util.Map;

public class Method {

    public void modifyUserInfo(String username, String address) {
        username = "San";
        address = "Beijing";
    }

    public void modifyUserInfo(String username, String address, boolean bool) {
        if (bool) {
            username = "San";
        } else {
            address = "Shanghai";
        }
    }

    public void modifyUserInfo(Map map) {
        UserInfo username = (UserInfo) map.get("username");
        //。。。 不建议

    }

    public void modifyUserInfo(String username, String... fileds) {
        username = "San";
        for (String filed : fileds) {
            //if 。。。不建议
        }
    }

    public void modifyUserName(String username) {
        username = "San";
    }

    public void modifyUserAddress(String address) {
        address = "Shenzhen";
    }

}
