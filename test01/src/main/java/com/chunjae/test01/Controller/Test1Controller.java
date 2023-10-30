package com.chunjae.test01.Controller;

import com.chunjae.test01.domain.Test1;
import com.chunjae.test01.mapper.Test1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class Test1Controller {

    @Autowired
    private Test1Mapper test1Mapper;

    @GetMapping("/test1/getList.do")
    @ResponseBody
    public List<Test1> getTestList() {
        return test1Mapper.getList();
    }

    @GetMapping("/test1/getList2.do")
    @ResponseBody
    public List<Test1> getTestList2() {
        return test1Mapper.getList2();
    }
}