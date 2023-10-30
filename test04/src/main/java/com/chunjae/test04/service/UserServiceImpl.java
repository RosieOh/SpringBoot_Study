package com.chunjae.test04.service;

import com.chunjae.test04.entity.User;
import com.chunjae.test04.persistance.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private userMapper userMapper;


    @Override
    public List<User> userList() throws Exception {
        return userMapper.userList();
    }

    @Override
    public User getUser(String id) throws Exception {
        return userMapper.getUser(id);
    }

    @Override
    public User insertUser(User user) throws Exception {
        return userMapper.insertUser(user);
    }

    @Override
    public User updateUser(User user) throws Exception {
        return userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(String id) throws Exception {
        userMapper.deleteUser(id);
    }

    @Override
    public int userCount() throws Exception {
        return 0;
    }

    @Override
    public User signIn(String id) throws Exception {
        return userMapper.signIn(id) ;
    }

    @Override
    public User loginCheck(User user) throws Exception {
        return userMapper.loginCheck(user);
    }

    @Override
    public User loginAjax(User user) throws Exception {
        return userMapper.loginAjax(user);
    }

    @Override
    public String findByEmail(String email) throws Exception {
        return userMapper.findByEmail(email);
    }

    @Override
    public String findByPassword(String id, String email) throws Exception {
        return userMapper.findByPassword(id, email);
    }

    @Override
    public User login(String id) throws Exception {
        return userMapper.login(id);
    }
}
