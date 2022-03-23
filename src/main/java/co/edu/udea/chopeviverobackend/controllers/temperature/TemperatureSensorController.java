package co.edu.udea.chopeviverobackend.controllers.temperature;

import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureHistoryEntity;
import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureSensorEntity;
import co.edu.udea.chopeviverobackend.services.temperature.interfaces.ITemperatureHistoryService;
import co.edu.udea.chopeviverobackend.services.temperature.interfaces.ITemperatureSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/temperature")
public class TemperatureSensorController {

    @Autowired
    private ITemperatureSensorService _sensorService;

    @Autowired
    private ITemperatureHistoryService _logsService;

    @GetMapping
    public ResponseEntity<List<TemperatureSensorEntity>> getSensors() {
        return ResponseEntity.ok(_sensorService.findAll());
    }

    @GetMapping(value = "/{serial}")
    public ResponseEntity<TemperatureSensorEntity> getSensorById(@PathVariable("serial") String id) {
        TemperatureSensorEntity sensor = _sensorService.findBySerial(id);
        if (sensor != null) {
            return ResponseEntity.ok(sensor);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping(value = "/measure")
    public ResponseEntity<List<TemperatureHistoryEntity>> getTemperatureLogs() {
        return ResponseEntity.ok(_logsService.findAll());
    }

}
