package org.example.kafka_embedded_rest_proxy_prac.controller;

import org.example.kafka_embedded_rest_proxy_prac.KafkaEmbeddedRestProxyPracApplication;
import org.example.kafka_embedded_rest_proxy_prac.dto.EventRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/events")
@CrossOrigin(origins = "*")  // 프론트와 통신 허용
public class EventController {

    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping
    public ResponseEntity<String> handleEvent(@RequestBody EventRequest eventRequest) {
        String topic = eventRequest.getTopic();
        String kafkaRestUrl = "http://localhost:8082/topics/" + topic;

        Map<String, Object> record = Map.of("value", Map.of(
                "message", eventRequest.getMessage(),
                "timestamp", System.currentTimeMillis()
        ));

        Map<String, Object> payload = Map.of("records", List.of(record));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("application/vnd.kafka.json.v2+json"));
        headers.setAccept(List.of(MediaType.valueOf("application/vnd.kafka.v2+json")));

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(payload, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(kafkaRestUrl, request, String.class);

        return ResponseEntity.status(response.getStatusCode()).body("Kafka로 전송 완료: " + eventRequest.getMessage());
    }
}
