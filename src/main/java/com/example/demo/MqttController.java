package com.example.demo;

import org.eclipse.paho.mqttv5.common.MqttException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mqtt")
public class MqttController {

    private final MqttPublisher mqttPublisher;
    private final MqttSubscriber mqttSubscriber;

    public MqttController(MqttPublisher mqttPublisher, MqttSubscriber mqttSubscriber) {
        this.mqttPublisher = mqttPublisher;
        this.mqttSubscriber = mqttSubscriber;
    }

    @GetMapping("/publish")
    public String publishMessage() {
        try {
            mqttPublisher.publishMessage("test/topic", "Hello, MQTT!");
            return "Message published successfully.";
        } catch (MqttException e) {
            return "Failed to publish message: " + e.getMessage();
        }
    }

    @GetMapping("/subscribe")
    public String subscribe() {
        try {
            mqttSubscriber.subscribe("test/topic");
            return "Subscribed to topic.";
        } catch (MqttException e) {
            return "Failed to subscribe: " + e.getMessage();
        }
    }
}
