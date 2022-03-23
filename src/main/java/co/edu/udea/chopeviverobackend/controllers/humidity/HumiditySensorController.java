package co.edu.udea.chopeviverobackend.controllers.humidity;


import co.edu.udea.chopeviverobackend.entites.humidity.HumidityHistoryEntity;
import co.edu.udea.chopeviverobackend.entites.humidity.HumiditySensorEntity;
import co.edu.udea.chopeviverobackend.services.humidity.interfaces.IHumidityHistoryService;
import co.edu.udea.chopeviverobackend.services.humidity.interfaces.IHumiditySensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/humidity")
public class HumiditySensorController {

    @Autowired
    private IHumiditySensorService _sensorService;

    @Autowired
    private IHumidityHistoryService _logsService;

    @GetMapping
    public ResponseEntity<List<HumiditySensorEntity>> getSensors() {
        return ResponseEntity.ok(_sensorService.findAll());
    }

    @GetMapping(value = "/{serial}")
    public ResponseEntity<HumiditySensorEntity> getSensorById(@PathVariable("serial") String id) {
        HumiditySensorEntity sensor = _sensorService.findBySerial(id);
        if (sensor != null) {
            return ResponseEntity.ok(sensor);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping(value = "/measure")
    public ResponseEntity<List<HumidityHistoryEntity>> getHumidityLogs() {
        return ResponseEntity.ok(_logsService.findAll());
    }

}
