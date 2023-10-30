package com.chunjae.test04.service;

import com.chunjae.test04.entity.User;

import java.util.List;

public interface UserService {
    public List<User> userList() throws Exception;
    public User getUser(String id) throws Exception;
    public User insertUser(User user) throws Exception;
    public User updateUser(User user) throws Exception;
    public void deleteUser(String id) throws Exception;
    public int userCount() throws Exception;
    public User signIn(String id) throws Exception;
    public User loginCheck(User user) throws Exception;
    public User loginAjax(User user) throws Exception;
    public String findByEmail(String email) throws Exception;
    public String findByPassword(String id, String email) throws Exception;
    public User login(String id) throws Exception;




}
