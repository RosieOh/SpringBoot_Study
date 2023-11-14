package com.pro07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Pro07Application {

    public static void main(String[] args) {
        SpringApplication.run(Pro07Application.class, args);
    }

}
