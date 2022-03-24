package co.edu.udea.chopeviverobackend.utils.mappers.humidity;

import co.edu.udea.chopeviverobackend.dtos.humidity.HumidityHistoryRequestDto;
import co.edu.udea.chopeviverobackend.dtos.humidity.HumidityHistoryResponseDto;
import co.edu.udea.chopeviverobackend.entites.humidity.HumidityHistoryEntity;
import co.edu.udea.chopeviverobackend.services.humidity.interfaces.IHumiditySensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class HumidityHistoryMapper {

    @Autowired
    private final IHumiditySensorService _sensorService;

    private final HumiditySensorMapper _sensorMapper;

    public HumidityHistoryEntity DtoToModel(HumidityHistoryRequestDto dto){
        HumidityHistoryEntity model = new HumidityHistoryEntity();
        model.setSensor(_sensorService.findBySerial(dto.getSensorSerial()));
        model.setHumidity(dto.getHumidity());
        return model;
    }
    public HumidityHistoryResponseDto ModelToDto(HumidityHistoryEntity model){
        HumidityHistoryResponseDto dto = new HumidityHistoryResponseDto();
        dto.setSensor(_sensorMapper.modelToDto(model.getSensor()));
        dto.setHumidity(model.getHumidity());
        dto.setTime(model.getTime());
        return dto;

    }

}
