package com.chunjae.test03.controller;

import com.chunjae.test03.entity.Euser;
import com.chunjae.test03.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("userList.do")
    public String getUserList(Model model) {
        List<Euser> userList = userService.getUserList();
        model.addAttribute("userList", userList);
        return "user/list";
    }

    @GetMapping("user.do")
    public String getUser(@RequestParam("name") String name, Model model) {
        Euser user = userService.getUser(name);
        model.addAttribute("user", user);
        return "user/get";
    }

    @GetMapping("insertUser.do")
    public String get
}
