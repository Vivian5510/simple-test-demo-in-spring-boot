package com.rosy.kafka_demo.config;

import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.Map;

public class KafkaConsumerConfig {
    public Map<String, Object> consumerConfigs() {
        return Map.ofEntries(
                Map.entry("bootstrap.servers", "localhost:9092"),
                Map.entry("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer"),
                Map.entry("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer"),
                Map.entry("group.id", "test-group"),
                Map.entry("enable.auto.commit", "true"),
                Map.entry("auto.commit.interval.ms", "1000"),
                Map.entry("auto.offset.reset", "earliest")
        );
    }

    public ConsumerFactory<String, Object> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    // @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> batchContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setBatchListener(true); // 启用批量消费模式
        factory.setConcurrency(3);     // 设置并发线程数
        return factory;
    }
}
