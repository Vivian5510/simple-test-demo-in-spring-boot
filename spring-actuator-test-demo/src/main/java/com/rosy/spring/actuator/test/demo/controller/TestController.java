package com.rosy.spring.actuator.test.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/hello")
    public String greet() {
        System.out.println("Hello");
        return "Hello From Rosy!";
    }
}
