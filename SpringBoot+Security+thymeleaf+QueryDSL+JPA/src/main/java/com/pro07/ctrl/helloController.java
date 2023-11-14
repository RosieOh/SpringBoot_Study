package com.pro07.ctrl;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class helloController {

    @GetMapping("/hello")
    public String hello1(Model model) throws Exception {
        String hello = "Hello Spring Boot JPA";
        log.info(hello);
        model.addAttribute("msg", hello);
        return "/hello1";
    }
}
