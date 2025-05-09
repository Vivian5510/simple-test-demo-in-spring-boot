package com.rosy.kafka_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenerConfig {

    private final ConsumerFactory<String, Object> consumerFactory;

    public KafkaListenerConfig(ConsumerFactory<String, Object> consumerFactory) {
        this.consumerFactory = consumerFactory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> batchContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.setBatchListener(true); // 启用批量消费模式
        factory.setConcurrency(3);     // 设置并发线程数
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> singleRecordContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.setBatchListener(false); // 默认单条消费模式
        factory.setConcurrency(3);       // 设置并发线程数
        return factory;
    }
}
