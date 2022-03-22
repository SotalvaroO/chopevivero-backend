package co.edu.udea.chopeviverobackend.repositories.temperature;

import co.edu.udea.chopeviverobackend.entites.temperature.TemperatureHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
Se hará uso de este repositorio para crearlos registros de temperatura a lo largo del tiempo
*/

@Repository
public interface ITemperatureHistoryRepository extends JpaRepository<TemperatureHistoryEntity, Long> {
}
