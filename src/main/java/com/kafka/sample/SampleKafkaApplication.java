package com.kafka.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class SampleKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleKafkaApplication.class, args);
    }

}
