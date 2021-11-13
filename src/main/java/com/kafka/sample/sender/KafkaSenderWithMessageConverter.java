package com.kafka.sample.sender;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * Created by Tharindu Eranga on 13/Nov/2021
 */
@RequiredArgsConstructor
@Component
public class KafkaSenderWithMessageConverter {

    private final Logger LOG = LoggerFactory.getLogger(KafkaSenderWithMessageConverter.class);

    private final KafkaTemplate<String, ?> kafkaTemplate;

    public void sendMessageWithConverter(Message<?> user) {
        LOG.info("Sending With Message Converter : {}", user);
        LOG.info("--------------------------------");

        kafkaTemplate.send(user);
    }

}