package co.edu.udea.chopeviverobackend.services.radiation.interfaces;

import co.edu.udea.chopeviverobackend.entites.radiation.RadiationSensorEntity;
import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureSensorEntity;

import java.util.List;

public interface IRadiationSensorService {

    List<RadiationSensorEntity> findAll();

    RadiationSensorEntity findById(Long id);

    RadiationSensorEntity findBySerial(String serial);

    RadiationSensorEntity deleteById(Long id);

}
