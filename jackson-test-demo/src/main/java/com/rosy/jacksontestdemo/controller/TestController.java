package com.rosy.jacksontestdemo.controller;

import com.rosy.jacksontestdemo.model.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public Response<String> test() {
        return new Response<>(200, "ok", "Hello World");
    }
}
