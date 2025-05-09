package com.rosy.emaildemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("2156722358@qq.com"); // 发件人
        message.setTo("2156722358@qq.com"); // 收件人
        message.setSubject("Test"); // 主题
        message.setText("Test"); // 内容
        mailSender.send(message);
    }
}
