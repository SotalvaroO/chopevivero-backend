package co.edu.udea.chopeviverobackend.services.humidity.implementations;

import co.edu.udea.chopeviverobackend.entites.humidity.HumiditySensorEntity;
import co.edu.udea.chopeviverobackend.entites.radiation.RadiationSensorEntity;
import co.edu.udea.chopeviverobackend.repositories.humidity.IHumiditySensorRepository;
import co.edu.udea.chopeviverobackend.repositories.radiation.IRadiationSensorRepository;
import co.edu.udea.chopeviverobackend.services.humidity.interfaces.IHumiditySensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor

@Service
public class HumiditySensorServiceImpl implements IHumiditySensorService {

    private final IHumiditySensorRepository _humiditySensorRepository;

    @Override
    public List<HumiditySensorEntity> findAll() {
        return _humiditySensorRepository.findAll();
    }

    @Override
    public HumiditySensorEntity findById(Long id) {
        return _humiditySensorRepository.findById(id).orElse(null);
    }

    @Override
    public HumiditySensorEntity findBySerial(String serial) {
        return _humiditySensorRepository.findBySerial(serial).orElse(null);
    }

    @Override
    public HumiditySensorEntity deleteById(Long id) {
        HumiditySensorEntity sensor = findById(id);
        if (sensor != null){
            _humiditySensorRepository.deleteById(id);
            return sensor;
        }
        return null;
    }
}
