package com.example.simple_responsibility.newer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private int id;
    private String username;
    private String password;
    private String sex;
    private Integer roleId;
}
