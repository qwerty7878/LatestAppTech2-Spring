package com.example.controllertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class ControllertestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControllertestApplication.class, args);
    }

}
