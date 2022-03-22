package co.edu.udea.chopeviverobackend.services.radiation.implementations;

import co.edu.udea.chopeviverobackend.entites.radiation.RadiationHistoryEntity;
import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureHistoryEntity;
import co.edu.udea.chopeviverobackend.repositories.radiation.IRadiationHistoryRepository;
import co.edu.udea.chopeviverobackend.services.radiation.interfaces.IRadiationHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor

@Service
public class RadiationHistoryServiceImpl implements IRadiationHistoryService {

    private final IRadiationHistoryRepository _radiationLogRepository;

    @Override
    public List<RadiationHistoryEntity> findAll() {
        return _radiationLogRepository.findByOrderByTimeAsc();
    }

    @Override
    public RadiationHistoryEntity create(RadiationHistoryEntity log) {
        return _radiationLogRepository.save(log);
    }
}
