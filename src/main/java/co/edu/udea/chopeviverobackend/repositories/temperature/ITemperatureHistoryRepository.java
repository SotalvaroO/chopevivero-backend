package co.edu.udea.chopeviverobackend.repositories.temperature;

import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureHistoryEntity;
import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureSensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/*
Se hará uso de este repositorio para crearlos registros de temperatura a lo largo del tiempo
*/

@Repository
public interface ITemperatureHistoryRepository extends JpaRepository<TemperatureHistoryEntity, Long> {

    List<TemperatureHistoryEntity> findByOrderByTimeAsc();

    TemperatureHistoryEntity findBySensorAndTime(TemperatureSensorEntity sensor, Date time);

}
