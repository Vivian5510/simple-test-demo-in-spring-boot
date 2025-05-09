package com.rosy.kafka_demo.config;

import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

public class KafkaProducerConfig {
    public Map<String, Object> producerConfigs() {
        return Map.ofEntries(
                Map.entry("bootstrap.servers", "localhost:9092"),
                Map.entry("key.serializer", "org.apache.kafka.common.serialization.StringSerializer"),
                Map.entry("value.serializer", "org.apache.kafka.common.serialization.StringSerializer"),
                Map.entry("acks", "all"),
                Map.entry("retries", 0),
                Map.entry("batch.size", 16384),
                Map.entry("linger.ms", 1),
                Map.entry("buffer.memory", 33554432)
        );
    }

    public ProducerFactory<Object, Object> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    // @Bean
    public KafkaTemplate<Object, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
