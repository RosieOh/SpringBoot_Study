package com.chunjae.test03.service;

import com.chunjae.test03.entity.Euser;

import java.util.List;

public interface UserService {
    public List<Euser> getUserList();
    public Euser getUser(String name);
    public void getWithdraw(String name);
    public void getActivate(String name);
    public void getDormant(String name);
    public List<Euser> getByEmail(String email);
    public List<Euser> getByName(String name);
    public List<Euser> findByEmail(String email, String tel);
    public List<Euser> findByPw(String email, String tel, String name);

}