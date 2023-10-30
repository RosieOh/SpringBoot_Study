package com.chunjae.test04.entity;

import lombok.Data;

@Data
public class UserInfo {
    private String userId;
    private String userName;
    private String password;
    private String email;
    private String tel;
    private String regdate;
    private int point;
    private String using;
    private String authorities;
    private String authority;
    private String authorityNm;
    private int auth;
}
