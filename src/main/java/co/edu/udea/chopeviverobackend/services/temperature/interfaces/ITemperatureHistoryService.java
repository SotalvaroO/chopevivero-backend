package co.edu.udea.chopeviverobackend.services.temperature.interfaces;

import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureHistoryEntity;

import java.util.List;

public interface ITemperatureHistoryService {

    List<TemperatureHistoryEntity> findAll();

    TemperatureHistoryEntity create(TemperatureHistoryEntity log);

}
