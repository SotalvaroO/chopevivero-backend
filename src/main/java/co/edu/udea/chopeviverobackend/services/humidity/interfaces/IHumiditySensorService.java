package co.edu.udea.chopeviverobackend.services.humidity.interfaces;

import co.edu.udea.chopeviverobackend.entites.humidity.HumiditySensorEntity;
import co.edu.udea.chopeviverobackend.entites.radiation.RadiationSensorEntity;

import java.util.List;

public interface IHumiditySensorService {

    List<HumiditySensorEntity> findAll();

    HumiditySensorEntity findById(Long id);

    HumiditySensorEntity findBySerial(String serial);

    HumiditySensorEntity deleteById(Long id);

}
