package com.example.demo;


import org.eclipse.paho.mqttv5.client.MqttClient;
import org.eclipse.paho.mqttv5.common.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqttPublisher {

    private final MqttClient mqttClient;

    @Autowired
    public MqttPublisher(MqttClient mqttClient) {
        this.mqttClient = mqttClient;
    }

    public void publishMessage(String topic, String message) throws MqttException {
        mqttClient.publish(topic, message.getBytes(), 0, false);
    }
}
