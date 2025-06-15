package org.example.kafka_embedded_rest_proxy_prac.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaDirectProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaDirectProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendToKafka(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }
}
