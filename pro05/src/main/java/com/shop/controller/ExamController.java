package com.shop.controller;

import com.shop.entity.Sample;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/ex")
public class ExamController {

    @GetMapping("/sample1")
    public String getSample1(Model model) {
        List<String> nameList = Arrays.asList("kim", "lee", "park", "oh");
        Sample sample = new Sample(1000L, "오레오", 1004);
        model.addAttribute("sample", sample);

        model.addAttribute("names", nameList);
        return "exam/sample1";
    }

    @GetMapping("/sample2")
    public String getSample2(Model model) {
        // 부가 설명 추가하자
        // Name1 ~ Name10
        List<String> strList = IntStream.range(1, 10).mapToObj(i -> "Name" + 1).collect(Collectors.toList());
        model.addAttribute("List", strList);

        Map<String, String> map = new HashMap<>();
        map.put("k", "KIM");
        map.put("L", "LEE");
        map.put("P", "PARK");
        map.put("S", "SHIN");
        model.addAttribute("map", map);

        Set<String> set = new HashSet<>();
        set.add("OH");
        set.add("HAN");
        set.add("SEO");
        set.add("LEE");
        set.add("HWANG");
        set.add("HAN");
        model.addAttribute("set", set);
        return "exam/sample2";
    }

    @GetMapping("/sample3")
    public String getSample3(Model model) {
        String[] cate = new String[]{"Company", "Service", "Product", "Community"};
        model.addAttribute("cate", cate);
        return "exam/sample3";
    }
}
