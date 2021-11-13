package com.kafka.sample;

import com.kafka.sample.model.User;
import com.kafka.sample.sender.KafkaSenderExample;
import com.kafka.sample.sender.KafkaSenderWithMessageConverter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.GenericMessage;

@Slf4j
@SpringBootTest
class SampleKafkaApplicationTests {

    @Autowired
    private KafkaSenderExample kafkaSenderExample;

    @Autowired
    private KafkaSenderWithMessageConverter messageConverterSender;

    @Value("${io.reflectoring.kafka.topic-1}")
    private String topic1;

    @Value("${io.reflectoring.kafka.topic-2}")
    private String topic2;

    @Value("${io.reflectoring.kafka.topic-3}")
    private String topic3;

    @Test
    void contextLoads() {
        log.info("---------------------------------");
        kafkaSenderExample.sendMessage("I'll be recevied by MultipleTopicListener, Listener & ClassLevel KafkaHandler", topic1);

        log.info("---------------------------------");
        kafkaSenderExample.sendMessage("I'll be received by ListenToPartitionWithOffset", topic3);

        log.info("---------------------------------");
        kafkaSenderExample.sendMessageWithCallback("I'll get a asyc Callback", "reflectoring-others");

        log.info("---------------------------------");
        kafkaSenderExample.sendMessageWithCallback("I'm sent using RoutingTemplate", "reflectoring-bytes");

        log.info("---------------------------------");
        kafkaSenderExample.sendMessage("I'll be ignored by RecordFilter", topic3);

        log.info("---------------------------------");
        kafkaSenderExample.sendMessage("I will get reply back from @SendTo", "reflectoring-others");

        log.info("---------------------------------");
        kafkaSenderExample.sendCustomMessage(new User("Lucario"), "reflectoring-user");

        log.info("---------------------------------");
        messageConverterSender.sendMessageWithConverter(new GenericMessage<>(new User("Pikachu")));
    }

}
