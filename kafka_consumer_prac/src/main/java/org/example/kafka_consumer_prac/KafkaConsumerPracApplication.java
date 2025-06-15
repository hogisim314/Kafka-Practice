package org.example.kafka_consumer_prac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class KafkaConsumerPracApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerPracApplication.class, args);
    }

}
