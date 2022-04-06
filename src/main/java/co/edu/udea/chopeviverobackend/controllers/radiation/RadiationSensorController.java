package co.edu.udea.chopeviverobackend.controllers.radiation;

import co.edu.udea.chopeviverobackend.dtos.radiation.RadiationHistoryRequestDto;
import co.edu.udea.chopeviverobackend.dtos.radiation.RadiationHistoryResponseDto;
import co.edu.udea.chopeviverobackend.dtos.radiation.RadiationSensorDto;
import co.edu.udea.chopeviverobackend.entites.radiation.RadiationHistoryEntity;
import co.edu.udea.chopeviverobackend.entites.radiation.RadiationSensorEntity;
import co.edu.udea.chopeviverobackend.services.radiation.interfaces.IRadiationHistoryService;
import co.edu.udea.chopeviverobackend.services.radiation.interfaces.IRadiationSensorService;
import co.edu.udea.chopeviverobackend.utils.mappers.radiation.RadiationHistoryMapper;
import co.edu.udea.chopeviverobackend.utils.mappers.radiation.RadiationSensorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
@RequestMapping(value = "/api/radiation")
public class RadiationSensorController {

    private final IRadiationSensorService _sensorService;

    private final IRadiationHistoryService _logsService;

    private final RadiationSensorMapper _sensorMapper;

    private final RadiationHistoryMapper _logsMapper;

    @GetMapping
    public ResponseEntity<List<RadiationSensorDto>> getSensors() {
        List<RadiationSensorDto> radiationDto = new ArrayList<>();
        List<RadiationSensorEntity> radiation = _sensorService.findAll();
        for (RadiationSensorEntity t : radiation
        ) {
            radiationDto.add(_sensorMapper.modelToDto(t));
        }
        return ResponseEntity.ok(radiationDto);
    }

    @GetMapping(value = "/{serial}")
    public ResponseEntity<RadiationSensorDto> getSensorById(@PathVariable("serial") String serial) {
        RadiationSensorEntity sensor = _sensorService.findBySerial(serial);
        if (sensor != null) {
            return ResponseEntity.ok(_sensorMapper.modelToDto(sensor));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping(value = "/measure")
    public ResponseEntity<List<RadiationHistoryResponseDto>> getRadiationLogs() {
        List<RadiationHistoryResponseDto> logsDto = new ArrayList<>();
        List<RadiationHistoryEntity> logs = _logsService.findAll();
        for (RadiationHistoryEntity t : logs
        ) {
            logsDto.add(_logsMapper.ModelToDto(t));
        }

        return ResponseEntity.ok(logsDto);
    }

    @PostMapping(value ="/measure")
    public ResponseEntity<RadiationHistoryResponseDto> createRadiationLog(@RequestBody RadiationHistoryRequestDto logDto){
        RadiationSensorEntity sensor = _sensorService.findBySerial(logDto.getSensorSerial());
        if (sensor != null){
            RadiationHistoryEntity responseLog = _logsService.create(_logsMapper.DtoToModel(logDto));
            RadiationHistoryResponseDto responseDto = _logsMapper.ModelToDto(responseLog);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
        }
        return ResponseEntity.badRequest().build();
    }
}
