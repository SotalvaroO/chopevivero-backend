package co.edu.udea.chopeviverobackend.services.mosquitto;

import co.edu.udea.chopeviverobackend.dtos.humidity.HumidityHistoryRequestDto;
import co.edu.udea.chopeviverobackend.dtos.radiation.RadiationHistoryRequestDto;
import co.edu.udea.chopeviverobackend.dtos.temperature.TemperatureHistoryRequestDto;
import co.edu.udea.chopeviverobackend.dtos.temperature.TemperatureSensorDto;
import co.edu.udea.chopeviverobackend.entites.humidity.HumidityHistoryEntity;
import co.edu.udea.chopeviverobackend.entites.radiation.RadiationHistoryEntity;
import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureHistoryEntity;
import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureSensorEntity;
import co.edu.udea.chopeviverobackend.services.humidity.interfaces.IHumidityHistoryService;
import co.edu.udea.chopeviverobackend.services.radiation.interfaces.IRadiationHistoryService;
import co.edu.udea.chopeviverobackend.services.temperature.interfaces.ITemperatureHistoryService;
import co.edu.udea.chopeviverobackend.services.temperature.interfaces.ITemperatureSensorService;
import co.edu.udea.chopeviverobackend.utils.mappers.humidity.HumidityHistoryMapper;
import co.edu.udea.chopeviverobackend.utils.mappers.radiation.RadiationHistoryMapper;
import co.edu.udea.chopeviverobackend.utils.mappers.temperature.TemperatureHistoryMapper;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MessagingService {

    @Autowired
    private IMqttClient mqttClient;
    @Autowired
    private ITemperatureHistoryService _temperatureLogService;
    @Autowired
    private IHumidityHistoryService _humidityLogService;
    @Autowired
    private IRadiationHistoryService _radiationLogService;
    @Autowired
    TemperatureHistoryMapper _temperatureLogMapper;
    @Autowired
    HumidityHistoryMapper _humidityLogMapper;
    @Autowired
    RadiationHistoryMapper _radiationLogMapper;

    public void publish(final String topic, final String payload, int qos, boolean retained)
            throws MqttPersistenceException, MqttException {

        MqttMessage mqttMessage = new MqttMessage();
        mqttMessage.setPayload(payload.getBytes());
        mqttMessage.setQos(qos);
        mqttMessage.setRetained(retained);

        //mqttClient.publish(topic, mqttMessage);

        mqttClient.publish(topic, payload.getBytes(), qos, retained);

        //mqttClient.disconnect();
    }

    public void subscribe(final String topic) throws MqttException, InterruptedException {
        System.out.println("Messages received:");

        mqttClient.subscribeWithResponse(topic, (tpic, msg) -> {

            String sensor = tpic.split("/")[1];
            String sensorSerial = tpic.split("/")[2];

            String parsedMsg = msg.toString().replace("{", "").replace("}", "");
            JSONParser parser = new JSONParser();
            Map<String, String> obj = convertWithStream(parsedMsg);

            switch (sensor) {
                case "temperature":
                    TemperatureHistoryRequestDto temperatureLog = new TemperatureHistoryRequestDto();
                    temperatureLog.setSensorSerial(sensorSerial);
                    temperatureLog.setTemperature(Double.parseDouble(obj.get("temperature")));
                    TemperatureHistoryEntity createdTemperature = _temperatureLogService.create(_temperatureLogMapper.DtoToModel(temperatureLog));
                    break;

                case "humidity":
                    HumidityHistoryRequestDto humidityLog = new HumidityHistoryRequestDto();
                    humidityLog.setSensorSerial(sensorSerial);
                    humidityLog.setHumidity(Double.parseDouble(obj.get("humidity")));
                    HumidityHistoryEntity createdHumidity = _humidityLogService.create(_humidityLogMapper.DtoToModel(humidityLog));
                    break;

                case "radiation":
                    RadiationHistoryRequestDto radiationLog = new RadiationHistoryRequestDto();
                    radiationLog.setSensorSerial(sensorSerial);
                    radiationLog.setRadiation(Double.parseDouble(obj.get("radiation")));
                    RadiationHistoryEntity createdRadiation = _radiationLogService.create(_radiationLogMapper.DtoToModel(radiationLog));
                    break;

            }


            System.out.println(msg.getId() + " -> " + new String(msg.getPayload()));
        });
    }

    public Map<String, String> convertWithStream(String mapAsString) {
        Map<String, String> map = Arrays.stream(mapAsString.split(","))
                .map(entry -> entry.split("[=:]"))
                .collect(Collectors.toMap(entry -> entry[0], entry -> entry[1]));
        return map;

    }
}