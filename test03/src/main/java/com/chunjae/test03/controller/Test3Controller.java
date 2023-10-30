package com.chunjae.test03.controller;

import com.chunjae.test03.domain.Test3;
import com.chunjae.test03.mapper.Test3Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class Test3Controller {

    @Autowired
    private Test3Mapper test3Mapper;

    @GetMapping("/test3/getList.do")
    @ResponseBody
    public List<Test3> getTestList() {
        return test3Mapper.getList();
    }

    @GetMapping("/test3/getList2.do")
    @ResponseBody
    public List<Test3> getTestList2() {
        return test3Mapper.getList2();
    }
}

