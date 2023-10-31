package com.chunjae.test03.config;

import com.chunjae.test03.service.UserService;
import com.chunjae.test03.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.chunjae.test03")
public class ApplicationConfig {
    // User
    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }
}
