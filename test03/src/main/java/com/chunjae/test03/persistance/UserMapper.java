package com.chunjae.test03.persistance;

import com.chunjae.test03.entity.Euser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<Euser> getUserList();
    Euser getUser(String name);
    void getWithdraw(String name);
    void getActivate(String name);
    void getDormant(String name);
    List<Euser> getByEmail(String email);
    List<Euser> getByName(String name);
    List<Euser> findByEmail(String email, String tel);
    List<Euser> findByPw(String email, String tel, String name);
}
