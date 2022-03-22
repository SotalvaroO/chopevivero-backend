package co.edu.udea.chopeviverobackend.services.temperature.implementations;

import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureSensorEntity;
import co.edu.udea.chopeviverobackend.repositories.temperature.ITemperatureSensorRepository;
import co.edu.udea.chopeviverobackend.services.temperature.interfaces.ITemperatureSensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor

@Service
public class TemperatureSensorServiceImpl implements ITemperatureSensorService {

    private final ITemperatureSensorRepository _temperatureSensorRepository;

    @Override
    public List<TemperatureSensorEntity> findAll() {
        return _temperatureSensorRepository.findAll();
    }

    @Override
    public TemperatureSensorEntity findById(Long id) {
        return _temperatureSensorRepository.findById(id).orElse(null);
    }

    @Override
    public TemperatureSensorEntity findBySerial(String serial) {
        return _temperatureSensorRepository.findBySerial(serial).orElse(null);
    }

    @Override
    public TemperatureSensorEntity deleteById(Long id) {
        TemperatureSensorEntity sensor = findById(id);
        if (sensor != null){
            _temperatureSensorRepository.deleteById(id);
            return sensor;
        }
        return null;
    }
}
