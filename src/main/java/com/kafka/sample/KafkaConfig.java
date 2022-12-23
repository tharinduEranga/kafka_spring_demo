package com.kafka.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.LoggingErrorHandler;

@Configuration
public class KafkaConfig {
    @Bean
    public LoggingErrorHandler errorHandler() {
        return new LoggingErrorHandler();
    }
}
