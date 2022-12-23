package com.kafka.sample;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class Consumer {

    @KafkaListener(topics = "users", groupId = "group_id")
    public void consume(String message) {
        log.info("Consumed message: {}", message);
    }
}
