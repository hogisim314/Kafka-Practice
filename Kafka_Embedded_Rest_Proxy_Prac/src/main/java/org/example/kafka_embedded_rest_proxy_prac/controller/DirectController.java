package org.example.kafka_embedded_rest_proxy_prac.controller;

import org.example.kafka_embedded_rest_proxy_prac.dto.EventRequest;
import org.example.kafka_embedded_rest_proxy_prac.service.KafkaDirectProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/direct")
@CrossOrigin("*")
public class DirectController {
    private final KafkaDirectProducer kafkaDirectProducer;

    public DirectController(KafkaDirectProducer kafkaDirectProducer) {
        this.kafkaDirectProducer = kafkaDirectProducer;
    }

    @PostMapping
    public ResponseEntity<String> sendDirect(@RequestBody EventRequest event) {
        kafkaDirectProducer.sendToKafka(event.getTopic(), event.getMessage());
        return ResponseEntity.ok("Kafka 클라이언트로 전송 완료");
    }
}
