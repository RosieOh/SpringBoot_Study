package com.chunjae.test03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@Controller // 인덱스가 안될 경우 컨트롤러로 진행
public class Test03Application {

    public static void main(String[] args) {
        SpringApplication.run(Test03Application.class, args);
    }

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

}
