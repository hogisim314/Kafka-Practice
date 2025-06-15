package org.example.kafka_embedded_rest_proxy_prac.dto;


public class EventRequest {
    private String topic;
    private String message;

    public EventRequest() {
    }

    public EventRequest(String topic, String message) {
        this.topic = topic;
        this.message = message;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}