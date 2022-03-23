package co.edu.udea.chopeviverobackend.utils.mappers.temperature;

import co.edu.udea.chopeviverobackend.dtos.temperature.TemperatureHistoryRequestDto;
import co.edu.udea.chopeviverobackend.dtos.temperature.TemperatureHistoryResponseDto;
import co.edu.udea.chopeviverobackend.dtos.temperature.TemperatureSensorDto;
import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureHistoryEntity;
import co.edu.udea.chopeviverobackend.services.temperature.interfaces.ITemperatureHistoryService;
import co.edu.udea.chopeviverobackend.services.temperature.interfaces.ITemperatureSensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TemperatureHistoryMapper {

    @Autowired
    private final ITemperatureSensorService _sensorService;

    private final TemperatureSensorMapper _sensorMapper;

    public TemperatureHistoryEntity DtoToModel(TemperatureHistoryRequestDto dto){
        TemperatureHistoryEntity model = new TemperatureHistoryEntity();
        model.setSensor(_sensorService.findBySerial(dto.getSensorSerial()));
        model.setTemperature(dto.getTemperature());
        return model;
    }
    public TemperatureHistoryResponseDto ModelToDto(TemperatureHistoryEntity model){
        TemperatureHistoryResponseDto dto = new TemperatureHistoryResponseDto();
        dto.setSensor(_sensorMapper.modelToDto(model.getSensor()));
        dto.setTemperature(model.getTemperature());
        dto.setTime(model.getTime());
        return dto;

    }

}
