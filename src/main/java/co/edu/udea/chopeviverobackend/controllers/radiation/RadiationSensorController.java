package co.edu.udea.chopeviverobackend.controllers.radiation;

import co.edu.udea.chopeviverobackend.entites.humidity.HumidityHistoryEntity;
import co.edu.udea.chopeviverobackend.entites.humidity.HumiditySensorEntity;
import co.edu.udea.chopeviverobackend.entites.radiation.RadiationHistoryEntity;
import co.edu.udea.chopeviverobackend.entites.radiation.RadiationSensorEntity;
import co.edu.udea.chopeviverobackend.services.radiation.interfaces.IRadiationHistoryService;
import co.edu.udea.chopeviverobackend.services.radiation.interfaces.IRadiationSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/radiation")
public class RadiationSensorController {

    @Autowired
    private IRadiationSensorService _sensorService;

    @Autowired
    private IRadiationHistoryService _logsService;

    @GetMapping
    public ResponseEntity<List<RadiationSensorEntity>> getSensors() {
        return ResponseEntity.ok(_sensorService.findAll());
    }

    @GetMapping(value = "/{serial}")
    public ResponseEntity<RadiationSensorEntity> getSensorById(@PathVariable("serial") String id) {
        RadiationSensorEntity sensor = _sensorService.findBySerial(id);
        if (sensor != null) {
            return ResponseEntity.ok(sensor);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping(value = "/measure")
    public ResponseEntity<List<RadiationHistoryEntity>> getHumidityLogs() {
        return ResponseEntity.ok(_logsService.findAll());
    }

}
