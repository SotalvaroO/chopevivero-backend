package co.edu.udea.chopeviverobackend.repositories.temperature;

import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureSensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
Se hará uso de este repositorio para crear o eliminar nuevos sensores de temperatura
*/

@Repository
public interface ITemperatureSensorRepository extends JpaRepository<TemperatureSensorEntity, Long> {
}
