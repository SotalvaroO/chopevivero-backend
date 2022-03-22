package co.edu.udea.chopeviverobackend.services.humidity.interfaces;

import co.edu.udea.chopeviverobackend.entites.humidity.HumidityHistoryEntity;
import co.edu.udea.chopeviverobackend.entites.radiation.RadiationHistoryEntity;

import java.util.List;

public interface IHumidityHistoryService {

    List<HumidityHistoryEntity> findAll();

    HumidityHistoryEntity create(HumidityHistoryEntity log);

}
