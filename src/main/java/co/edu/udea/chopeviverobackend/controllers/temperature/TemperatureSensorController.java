package co.edu.udea.chopeviverobackend.controllers.temperature;

import co.edu.udea.chopeviverobackend.dtos.temperature.TemperatureHistoryRequestDto;
import co.edu.udea.chopeviverobackend.dtos.temperature.TemperatureHistoryResponseDto;
import co.edu.udea.chopeviverobackend.dtos.temperature.TemperatureSensorDto;
import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureHistoryEntity;
import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureSensorEntity;
import co.edu.udea.chopeviverobackend.services.temperature.interfaces.ITemperatureHistoryService;
import co.edu.udea.chopeviverobackend.services.temperature.interfaces.ITemperatureSensorService;
import co.edu.udea.chopeviverobackend.utils.mappers.temperature.TemperatureHistoryMapper;
import co.edu.udea.chopeviverobackend.utils.mappers.temperature.TemperatureSensorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping(value = "/api/temperature")
public class TemperatureSensorController {

    private final ITemperatureSensorService _sensorService;

    private final ITemperatureHistoryService _logsService;

    private final TemperatureSensorMapper _sensorMapper;

    private final TemperatureHistoryMapper _logsMapper;

    @GetMapping
    public ResponseEntity<List<TemperatureSensorDto>> getSensors() {
        List<TemperatureSensorDto> temperatureDto = new ArrayList<>();
        List<TemperatureSensorEntity> temperature = _sensorService.findAll();
        for ( TemperatureSensorEntity t: temperature
             ) {
            temperatureDto.add(_sensorMapper.modelToDto(t));
        }
        return ResponseEntity.ok(temperatureDto);
    }

    @GetMapping(value = "/{serial}")
    public ResponseEntity<TemperatureSensorDto> getSensorById(@PathVariable("serial") String serial) {
        TemperatureSensorEntity sensor = _sensorService.findBySerial(serial);
        if (sensor != null) {
            return ResponseEntity.ok(_sensorMapper.modelToDto(sensor));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping(value = "/measure")
    public ResponseEntity<List<TemperatureHistoryResponseDto>> getTemperatureLogs() {
        List<TemperatureHistoryResponseDto> logsDto = new ArrayList<>();
        List<TemperatureHistoryEntity> logs = _logsService.findAll();
        for (TemperatureHistoryEntity t: logs
             ) {
            logsDto.add(_logsMapper.ModelToDto(t));
        }

        return ResponseEntity.ok(logsDto);
    }
    @PostMapping(value ="/measure")
    public ResponseEntity<TemperatureHistoryResponseDto> createTemperatureLog(@RequestBody TemperatureHistoryRequestDto logDto){
        TemperatureSensorEntity sensor = _sensorService.findBySerial(logDto.getSensorSerial());
        if (sensor != null){
            TemperatureHistoryEntity responseLog = _logsService.create(_logsMapper.DtoToModel(logDto));
            TemperatureHistoryResponseDto responseDto = _logsMapper.ModelToDto(responseLog);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
        }
        return ResponseEntity.badRequest().build();
    }

}
