package com.example.demo;

import org.eclipse.paho.mqttv5.client.MqttClient;
import org.eclipse.paho.mqttv5.common.MqttException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqttSubscriber {

    private static final Logger logger = LoggerFactory.getLogger(MqttSubscriber.class);

    private final MqttClient mqttClient;

    @Autowired
    public MqttSubscriber(MqttClient mqttClient) {
        this.mqttClient = mqttClient;
    }

    public void subscribe(String topic) throws MqttException {
        try {
            mqttClient.subscribe(topic, 1); // Ganti 0 dengan qos yang sesuai
            logger.info("Subscriber is now subscribed to topic: {}", topic);
            System.out.println(topic);
        } catch (MqttException e) {
            logger.error("Failed to subscribe: {}", e.getMessage(), e);
            throw e;
        }
    }
}
