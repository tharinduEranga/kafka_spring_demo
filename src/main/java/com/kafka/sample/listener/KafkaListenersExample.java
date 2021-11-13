package com.kafka.sample.listener;

import com.kafka.sample.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * Created by Tharindu Eranga on 13/Nov/2021
 */
@Slf4j
@Component
class KafkaListenersExample {

    @KafkaListener(topics = "reflectoring-1")
    public void listener(String message) {
        log.info("Listener [{}]", message);
    }

    @KafkaListener(topics = {"reflectoring-1", "reflectoring-2"}, groupId = "reflectoring-group-2")
    public void commonListenerForMultipleTopics(String message) {
        log.info("MultipleTopicListener - [{}]", message);
    }

    @KafkaListener(topicPartitions = @TopicPartition(topic = "reflectoring-3", partitionOffsets = {
            @PartitionOffset(partition = "0", initialOffset = "0")}), groupId = "reflectoring-group-3")
    public void listenToParitionWithOffset(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                                           @Header(KafkaHeaders.OFFSET) int offset) {
        log.info("ListenToPartitionWithOffset [{}] from partition-{} with offset-{}", message, partition, offset);
    }

    @KafkaListener(topics = "reflectoring-bytes")
    public void listenerForRoutingTemplate(String message) {
        log.info("RoutingTemplate BytesListener [{}]", message);
    }

    @KafkaListener(topics = "reflectoring-others")
    @SendTo("reflectoring-2")
    public String listenAndReply(String message) {
        log.info("ListenAndReply [{}]", message);
        return "This is a reply sent to 'reflectoring-2' topic after receiving message at 'reflectoring-others' topic";
    }

    @KafkaListener(id = "1", topics = "reflectoring-user", groupId = "reflectoring-user-mc", containerFactory = "kafkaJsonListenerContainerFactory")
    public void listenerWithMessageConverter(User user) {
        log.info("MessageConverterUserListener [{}]", user);
    }
}