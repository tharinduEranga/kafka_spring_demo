package com.kafka.sample;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class Producer {
    private static final String TOPIC = "users";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        log.info(String.format("#### -&gt; Producing message -&gt; %s", message));
        this.kafkaTemplate.send(TOPIC, message);
    }

}
