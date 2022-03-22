package co.edu.udea.chopeviverobackend.repositories.radiation;

import co.edu.udea.chopeviverobackend.entites.radiation.RadiationHistoryEntity;
import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
Se hará uso de este repositorio para crearlos registros de radiacion a lo largo del tiempo
*/

@Repository
public interface IRadiationHistoryRepository extends JpaRepository<RadiationHistoryEntity, Long> {
}
