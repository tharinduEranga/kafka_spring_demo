package com.kafka.sample.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Created by Tharindu Eranga on 13/Nov/2021
 */
@Configuration
class KafkaTopicConfig {

    @Value("${io.reflectoring.kafka.topic-1}")
    private String topic1;

    @Value("${io.reflectoring.kafka.topic-2}")
    private String topic2;

    @Value("${io.reflectoring.kafka.topic-3}")
    private String topic3;

    @Value("${io.reflectoring.kafka.topic-4}")
    private String topic4;

    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name(topic1).build();
    }

    @Bean
    public NewTopic topic2() {
        return TopicBuilder.name(topic2).build();
    }

    @Bean
    public NewTopic topic3() {
        return TopicBuilder.name(topic3).build();
    }

    @Bean
    public NewTopic topicUser() {
        return TopicBuilder.name(topic4).build();
    }

    @Bean
    public NewTopic topicBytes() {
        return TopicBuilder.name("reflectoring-bytes").build();
    }

    @Bean
    public NewTopic others() {
        return TopicBuilder.name("reflectoring-others").build();
    }
}