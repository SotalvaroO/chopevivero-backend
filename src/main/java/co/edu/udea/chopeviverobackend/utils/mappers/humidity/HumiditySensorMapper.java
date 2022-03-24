package co.edu.udea.chopeviverobackend.utils.mappers.humidity;

import co.edu.udea.chopeviverobackend.dtos.humidity.HumiditySensorDto;
import co.edu.udea.chopeviverobackend.entites.humidity.HumiditySensorEntity;
import org.springframework.stereotype.Component;

@Component
public class HumiditySensorMapper {

    public HumiditySensorDto modelToDto(HumiditySensorEntity sensor){
        HumiditySensorDto dto = new HumiditySensorDto();
        dto.setSerial(sensor.getSerial());
        dto.setName(sensor.getName());
        return dto;
    }

}
