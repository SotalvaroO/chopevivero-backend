package co.edu.udea.chopeviverobackend.services.radiation.interfaces;

import co.edu.udea.chopeviverobackend.entites.radiation.RadiationHistoryEntity;
import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureHistoryEntity;

import java.util.List;

public interface IRadiationHistoryService {

    List<RadiationHistoryEntity> findAll();

    RadiationHistoryEntity create(RadiationHistoryEntity log);

}
