package com.kafka.sample.sender;

import com.kafka.sample.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.RoutingKafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * Created by Tharindu Eranga on 13/Nov/2021
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class KafkaSenderExample {
    private KafkaTemplate<String, String> kafkaTemplate;
    private RoutingKafkaTemplate routingKafkaTemplate;
    private KafkaTemplate<String, User> userKafkaTemplate;

    @Autowired
    public KafkaSenderExample(KafkaTemplate<String, String> kafkaTemplate, RoutingKafkaTemplate routingKafkaTemplate,
                              KafkaTemplate<String, User> userKafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.routingKafkaTemplate = routingKafkaTemplate;
        this.userKafkaTemplate = userKafkaTemplate;
    }

    public void sendMessage(String message, String topicName) {
        log.info("Sending : {}", message);
        log.info("--------------------------------");

        kafkaTemplate.send(topicName, message);
    }

    public void sendWithRoutingTemplate(String message, String topicName) {
        log.info("Sending : {}", message);
        log.info("--------------------------------");

        routingKafkaTemplate.send(topicName, message.getBytes());
    }

    public void sendCustomMessage(User user, String topicName) {
        log.info("Sending Json Serializer : {}", user);
        log.info("--------------------------------");

        userKafkaTemplate.send(topicName, user);
    }

    public void sendMessageWithCallback(String message, String topicName) {
        log.info("Sending : {}", message);
        log.info("---------------------------------");

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("Success Callback: [{}] delivered with offset -{}", message,
                        result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.warn("Failure Callback: Unable to deliver message [{}]. {}", message, ex.getMessage());
            }
        });
    }
}