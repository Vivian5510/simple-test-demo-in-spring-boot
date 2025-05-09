package com.rosy.kafka_demo.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

public class CustomProducerInterceptor implements ProducerInterceptor<String, Object> {
    @Override
    public ProducerRecord<String, Object> onSend(ProducerRecord<String, Object> record) {
        System.out.println("ProducerInterceptor onSend: " + record.value());
        return record;
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
        System.out.println("ProducerInterceptor onAcknowledgement: " + metadata.offset());
        System.out.println("ProducerInterceptor onAcknowledgement: " + metadata.topic());
        System.out.println("ProducerInterceptor onAcknowledgement: " + metadata.partition());
        if (exception != null) System.out.println("Exception: " + exception.getMessage());
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
