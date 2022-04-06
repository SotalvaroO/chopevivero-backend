package co.edu.udea.chopeviverobackend.controllers.humidity;


import co.edu.udea.chopeviverobackend.dtos.humidity.HumidityHistoryRequestDto;
import co.edu.udea.chopeviverobackend.dtos.humidity.HumidityHistoryResponseDto;
import co.edu.udea.chopeviverobackend.dtos.humidity.HumiditySensorDto;
import co.edu.udea.chopeviverobackend.entites.humidity.HumidityHistoryEntity;
import co.edu.udea.chopeviverobackend.entites.humidity.HumiditySensorEntity;
import co.edu.udea.chopeviverobackend.services.humidity.interfaces.IHumidityHistoryService;
import co.edu.udea.chopeviverobackend.services.humidity.interfaces.IHumiditySensorService;
import co.edu.udea.chopeviverobackend.utils.mappers.humidity.HumidityHistoryMapper;
import co.edu.udea.chopeviverobackend.utils.mappers.humidity.HumiditySensorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
@RequestMapping(value = "/api/humidity")
public class HumiditySensorController {

    private final IHumiditySensorService _sensorService;

    private final IHumidityHistoryService _logsService;

    private final HumiditySensorMapper _sensorMapper;

    private final HumidityHistoryMapper _logsMapper;

    @GetMapping
    public ResponseEntity<List<HumiditySensorDto>> getSensors() {
        List<HumiditySensorDto> humidityDto = new ArrayList<>();
        List<HumiditySensorEntity> humidity = _sensorService.findAll();
        for ( HumiditySensorEntity t: humidity
        ) {
            humidityDto.add(_sensorMapper.modelToDto(t));
        }
        return ResponseEntity.ok(humidityDto);
    }

    @GetMapping(value = "/{serial}")
    public ResponseEntity<HumiditySensorDto> getSensorById(@PathVariable("serial") String serial) {
        HumiditySensorEntity sensor = _sensorService.findBySerial(serial);
        if (sensor != null) {
            return ResponseEntity.ok(_sensorMapper.modelToDto(sensor));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping(value = "/measure")
    public ResponseEntity<List<HumidityHistoryResponseDto>> getHumidityLogs() {
        List<HumidityHistoryResponseDto> logsDto = new ArrayList<>();
        List<HumidityHistoryEntity> logs = _logsService.findAll();
        for (HumidityHistoryEntity t: logs
        ) {
            logsDto.add(_logsMapper.ModelToDto(t));
        }

        return ResponseEntity.ok(logsDto);
    }

    @PostMapping(value ="/measure")
    public ResponseEntity<HumidityHistoryResponseDto> createHumidityLog(@RequestBody HumidityHistoryRequestDto logDto){
        HumiditySensorEntity sensor = _sensorService.findBySerial(logDto.getSensorSerial());
        if (sensor != null){
            HumidityHistoryEntity responseLog = _logsService.create(_logsMapper.DtoToModel(logDto));
            HumidityHistoryResponseDto responseDto = _logsMapper.ModelToDto(responseLog);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
        }
        return ResponseEntity.badRequest().build();
    }

}
