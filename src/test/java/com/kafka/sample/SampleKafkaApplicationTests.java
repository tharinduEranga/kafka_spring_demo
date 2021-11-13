package com.kafka.sample;

import com.kafka.sample.sender.KafkaSenderExample;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class SampleKafkaApplicationTests {

    @Autowired
    private KafkaSenderExample kafkaSenderExample;

    @Test
    void contextLoads() {
        log.info("Sending with callback...");
        kafkaSenderExample.sendMessageWithCallback("demo");
        log.info("Sent...");
    }

}
