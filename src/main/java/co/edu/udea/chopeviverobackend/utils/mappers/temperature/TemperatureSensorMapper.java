package co.edu.udea.chopeviverobackend.utils.mappers.temperature;

import co.edu.udea.chopeviverobackend.dtos.temperature.TemperatureSensorDto;
import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureSensorEntity;
import org.springframework.stereotype.Component;

@Component
public class TemperatureSensorMapper {

    public TemperatureSensorDto modelToDto(TemperatureSensorEntity sensor){
        TemperatureSensorDto dto = new TemperatureSensorDto();
        dto.setSerial(sensor.getSerial());
        dto.setName(sensor.getName());
        return dto;
    }

}
