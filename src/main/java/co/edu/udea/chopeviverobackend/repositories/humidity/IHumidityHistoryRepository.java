package co.edu.udea.chopeviverobackend.repositories.humidity;

import co.edu.udea.chopeviverobackend.entites.humidity.HumidityHistoryEntity;
import co.edu.udea.chopeviverobackend.entites.radiation.RadiationHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
Se hará uso de este repositorio para crearlos registros de humedad a lo largo del tiempo
*/

@Repository
public interface IHumidityHistoryRepository extends JpaRepository<HumidityHistoryEntity, Long> {
}
