package co.edu.udea.chopeviverobackend.utils.mappers.radiation;

import co.edu.udea.chopeviverobackend.dtos.radiation.RadiationHistoryRequestDto;
import co.edu.udea.chopeviverobackend.dtos.radiation.RadiationHistoryResponseDto;
import co.edu.udea.chopeviverobackend.entites.radiation.RadiationHistoryEntity;
import co.edu.udea.chopeviverobackend.services.radiation.interfaces.IRadiationSensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RadiationHistoryMapper {

    @Autowired
    private final IRadiationSensorService _sensorService;

    private final RadiationSensorMapper _sensorMapper;

    public RadiationHistoryEntity DtoToModel(RadiationHistoryRequestDto dto){
        RadiationHistoryEntity model = new RadiationHistoryEntity();
        model.setSensor(_sensorService.findBySerial(dto.getSensorSerial()));
        model.setRadiation(dto.getRadiation());
        return model;
    }
    public RadiationHistoryResponseDto ModelToDto(RadiationHistoryEntity model){
        RadiationHistoryResponseDto dto = new RadiationHistoryResponseDto();
        dto.setSensor(_sensorMapper.modelToDto(model.getSensor()));
        dto.setRadiation(model.getRadiation());
        dto.setTime(model.getTime());
        return dto;

    }

}
