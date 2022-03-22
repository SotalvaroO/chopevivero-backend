package co.edu.udea.chopeviverobackend.services.humidity.implementations;

import co.edu.udea.chopeviverobackend.entites.humidity.HumidityHistoryEntity;
import co.edu.udea.chopeviverobackend.entites.radiation.RadiationHistoryEntity;
import co.edu.udea.chopeviverobackend.repositories.humidity.IHumidityHistoryRepository;
import co.edu.udea.chopeviverobackend.repositories.radiation.IRadiationHistoryRepository;
import co.edu.udea.chopeviverobackend.services.humidity.interfaces.IHumidityHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor

@Service
public class HumidityHistoryServiceImpl implements IHumidityHistoryService {

    private final IHumidityHistoryRepository _humidityLogRepository;

    @Override
    public List<HumidityHistoryEntity> findAll() {
        return _humidityLogRepository.findByOrderByTimeAsc();
    }

    @Override
    public HumidityHistoryEntity create(HumidityHistoryEntity log) {
        return _humidityLogRepository.save(log);
    }
}
