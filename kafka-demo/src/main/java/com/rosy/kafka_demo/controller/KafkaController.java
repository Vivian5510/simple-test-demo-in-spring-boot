package com.rosy.kafka_demo.controller;


import com.rosy.kafka_demo.domain.entity.User;
import com.rosy.kafka_demo.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/send")
    public String sendMessage(User user) {
        kafkaProducer.sendMessage(user);
        return "Message sent to Kafka: " + user;
    }
}
