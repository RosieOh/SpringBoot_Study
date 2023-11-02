package com.chunjae.test07.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private int active;
    private String userName;
    private String loginId;
    private String password;
    private String passwordConfirm;
}
