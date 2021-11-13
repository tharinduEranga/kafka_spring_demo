package com.kafka.sample.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Created by Tharindu Eranga on 13/Nov/2021
 */
@Configuration
class KafkaTopicConfig {

    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name("reflectoring-1").build();
    }

    @Bean
    public NewTopic topic2() {
        return TopicBuilder.name("reflectoring-2").build();
    }

}