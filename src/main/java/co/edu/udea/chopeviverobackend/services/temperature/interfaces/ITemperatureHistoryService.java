package co.edu.udea.chopeviverobackend.services.temperature.interfaces;

import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureHistoryEntity;
import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureSensorEntity;

import java.util.Date;
import java.util.List;

public interface ITemperatureHistoryService {

    List<TemperatureHistoryEntity> findAll();

    TemperatureHistoryEntity findById(Long id);

    TemperatureHistoryEntity create(TemperatureHistoryEntity log);

    TemperatureHistoryEntity findBySensorAndDate(TemperatureSensorEntity sensor, Date time);

}
