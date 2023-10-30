package com.chunjae.test02.controller;

import com.chunjae.test02.domain.Test2;
import com.chunjae.test02.mapper.Test2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class Test2Controller {

    @Autowired
    private Test2Mapper test2Mapper;

    @GetMapping("/test2/getList.do")
    @ResponseBody
    public List<Test2> getTestList() {
        return test2Mapper.getList();
    }

    @GetMapping("/test2/getList2.do")
    @ResponseBody
    public List<Test2> getTestList2() {
        return test2Mapper.getList2();
    }
}
