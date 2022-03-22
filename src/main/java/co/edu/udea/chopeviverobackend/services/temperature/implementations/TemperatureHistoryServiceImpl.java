package co.edu.udea.chopeviverobackend.services.temperature.implementations;

import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureHistoryEntity;
import co.edu.udea.chopeviverobackend.repositories.temperature.ITemperatureHistoryRepository;
import co.edu.udea.chopeviverobackend.services.temperature.interfaces.ITemperatureHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor

@Service
public class TemperatureHistoryServiceImpl implements ITemperatureHistoryService {

    private final ITemperatureHistoryRepository _temperatureLogRepository;

    @Override
    public List<TemperatureHistoryEntity> findAll() {
        return _temperatureLogRepository.findByOrderByTimeAsc();
    }

    @Override
    public TemperatureHistoryEntity create(TemperatureHistoryEntity log) {
        return _temperatureLogRepository.save(log);
    }
}
