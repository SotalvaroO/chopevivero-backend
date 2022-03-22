package co.edu.udea.chopeviverobackend.services.temperature.interfaces;

import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureSensorEntity;

import java.util.List;

public interface ITemperatureSensorService {

    List<TemperatureSensorEntity> findAll();

    TemperatureSensorEntity findById(Long id);

    TemperatureSensorEntity findBySerial(String serial);

    TemperatureSensorEntity deleteById(Long id);

}
