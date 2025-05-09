package com.rosy.kafka_demo.consumer;

import com.rosy.kafka_demo.domain.entity.User;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaConsumer {

    @KafkaListener(groupId = "demo-consumer-group",
            topicPartitions = {
                    @TopicPartition(topic = "test-topic", partitions = {"1", "3"}),
                    @TopicPartition(topic = "test-topic-result", partitions = {"0"})
            })
    public void consumer1(User message) {
        System.out.println("consume1 received: " + message);
    }

    @KafkaListener(groupId = "demo-consumer-group",
            topicPartitions = @TopicPartition(
                    topic = "test-topic",
                    partitions = {"2", "4"}
            )
    )
    @SendTo("test-topic-result") //Send the return value to another topic
    public User consumer2(User message) {
        System.out.println("consume2 received: " + message);
        return message;
    }

    @KafkaListener(groupId = "demo-consumer-group",
            //topicPartitions can be a list of @TopicPartition
            topicPartitions = @TopicPartition(
                    topic = "test-topic",
                    //partitionOffsets can be a list of @PartitionOffset
                    partitionOffsets = @PartitionOffset(partition = "0", initialOffset = "20")
            ),
            batch = "true",   //Enable batch listening
            concurrency = "1" //the number of listener; When specific partitions are provided, the concurrency must be less than or equal to the number of partitions assigned to the consumer;
            //containerFactory = "batchContainerFactory" //Specify the containerFactory
    )
    public void batchConsumer(List<ConsumerRecord<String, Object>> records) {
        System.out.println("BatchConsumer received: " + records.size() + " messages");
        for (ConsumerRecord<String, Object> record : records) {
            System.out.println("BatchConsumer received: " + record.value());
        }
    }
}
