package co.edu.udea.chopeviverobackend.config;

import co.edu.udea.chopeviverobackend.services.mosquitto.MessagingService;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubscribeConfiguration {

    @Autowired
    private MessagingService messagingService;


    @Bean
    public void subscribe() throws MqttException, InterruptedException {
        final String topic = "/#";
        messagingService.subscribe(topic);
    }


}
