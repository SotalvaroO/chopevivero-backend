package co.edu.udea.chopeviverobackend.services.radiation.implementations;

import co.edu.udea.chopeviverobackend.entites.radiation.RadiationSensorEntity;
import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureSensorEntity;
import co.edu.udea.chopeviverobackend.repositories.radiation.IRadiationSensorRepository;
import co.edu.udea.chopeviverobackend.repositories.temperature.ITemperatureSensorRepository;
import co.edu.udea.chopeviverobackend.services.radiation.interfaces.IRadiationSensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor

@Service
public class RadiationSensorServiceImpl implements IRadiationSensorService {

    private final IRadiationSensorRepository _radiationSensorRepository;

    @Override
    public List<RadiationSensorEntity> findAll() {
        return _radiationSensorRepository.findAll();
    }

    @Override
    public RadiationSensorEntity findById(Long id) {
        return _radiationSensorRepository.findById(id).orElse(null);
    }

    @Override
    public RadiationSensorEntity findBySerial(String serial) {
        return _radiationSensorRepository.findBySerial(serial).orElse(null);
    }

    @Override
    public RadiationSensorEntity deleteById(Long id) {
        RadiationSensorEntity sensor = findById(id);
        if (sensor != null){
            _radiationSensorRepository.deleteById(id);
            return sensor;
        }
        return null;
    }
}
