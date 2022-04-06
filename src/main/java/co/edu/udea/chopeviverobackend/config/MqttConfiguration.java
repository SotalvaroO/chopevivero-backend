package co.edu.udea.chopeviverobackend.config;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "mqtt")
    public MqttConnectOptions mqttConnectOptions() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        options.setUserName("admin");
        String pass = "12345678";
        options.setPassword(pass.toCharArray());
        return options;
    }

    @Bean
    public IMqttClient mqttClient() throws MqttException {

        IMqttClient mqttClient = new MqttClient("tcp://localhost:1883", "Spring");


        mqttClient.connect(mqttConnectOptions());

        return mqttClient;
    }

}
