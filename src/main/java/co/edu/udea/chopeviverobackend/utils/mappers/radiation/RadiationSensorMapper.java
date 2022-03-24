package co.edu.udea.chopeviverobackend.utils.mappers.radiation;

import co.edu.udea.chopeviverobackend.dtos.radiation.RadiationSensorDto;
import co.edu.udea.chopeviverobackend.entites.radiation.RadiationSensorEntity;
import org.springframework.stereotype.Component;

@Component
public class RadiationSensorMapper {

    public RadiationSensorDto modelToDto(RadiationSensorEntity sensor){
        RadiationSensorDto dto = new RadiationSensorDto();
        dto.setSerial(sensor.getSerial());
        dto.setName(sensor.getName());
        return dto;
    }

}
