package com.rosy.emaildemo.controller;

import com.rosy.emaildemo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private MailService mailService;

    @GetMapping("/send-mail")
    public String sendMail() {
        mailService.sendSimpleMail();
        return "邮件发送成功";
    }
}
