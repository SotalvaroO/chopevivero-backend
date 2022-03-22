package co.edu.udea.chopeviverobackend.repositories.humidity;

import co.edu.udea.chopeviverobackend.entites.humidity.HumiditySensorEntity;
import co.edu.udea.chopeviverobackend.entites.radiation.RadiationSensorEntity;
import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureSensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
Se hará uso de este repositorio para crear o eliminar nuevos sensores de humedad
*/

@Repository
public interface IHumiditySensorRepository extends JpaRepository<HumiditySensorEntity, Long> {

    Optional<HumiditySensorEntity> findBySerial(String serial);

}
