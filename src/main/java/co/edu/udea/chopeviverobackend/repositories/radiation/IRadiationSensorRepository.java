package co.edu.udea.chopeviverobackend.repositories.radiation;

import co.edu.udea.chopeviverobackend.entites.radiation.RadiationSensorEntity;
import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureSensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
Se hará uso de este repositorio para crear o eliminar nuevos sensores de radiacion
*/

@Repository
public interface IRadiationSensorRepository extends JpaRepository<RadiationSensorEntity, Long> {
}
