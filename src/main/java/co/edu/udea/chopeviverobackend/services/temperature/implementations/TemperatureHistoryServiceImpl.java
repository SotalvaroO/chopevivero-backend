package co.edu.udea.chopeviverobackend.services.temperature.implementations;

import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureHistoryEntity;
import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureSensorEntity;
import co.edu.udea.chopeviverobackend.repositories.temperature.ITemperatureHistoryRepository;
import co.edu.udea.chopeviverobackend.repositories.temperature.ITemperatureSensorRepository;
import co.edu.udea.chopeviverobackend.services.temperature.interfaces.ITemperatureHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor

@Service
public class TemperatureHistoryServiceImpl implements ITemperatureHistoryService {

    private final ITemperatureHistoryRepository _temperatureLogRepository;

    private final ITemperatureSensorRepository _sensorRepository;

    @Override
    public List<TemperatureHistoryEntity> findAll() {
        return _temperatureLogRepository.findByOrderByTimeAsc();
    }

    @Override
    public TemperatureHistoryEntity findById(Long id) {
        return _temperatureLogRepository.findById(id).orElse(null);
    }

    @Override
    public TemperatureHistoryEntity create(TemperatureHistoryEntity log) {
        return _temperatureLogRepository.save(log);
    }

    @Override
    public TemperatureHistoryEntity findBySensorAndDate(TemperatureSensorEntity sensor, Date time) {
        TemperatureHistoryEntity log = _temperatureLogRepository.findBySensorAndTime(sensor, time);
        return log;
    }
}
