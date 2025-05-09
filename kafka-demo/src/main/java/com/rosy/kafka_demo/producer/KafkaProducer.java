package com.rosy.kafka_demo.producer;

import com.rosy.kafka_demo.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private static final String TOPIC = "test-topic";

    public void sendMessage(User user) {
        kafkaTemplate.send(TOPIC, 4, null, user);
        System.out.println("Message sent: " + user);
    }
}
