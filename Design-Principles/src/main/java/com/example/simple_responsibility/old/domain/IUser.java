package com.example.simple_responsibility.old.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IUser {
    private int id;
    private String username;
    private String password;
    private String sex;
    private Integer roleId;
}
