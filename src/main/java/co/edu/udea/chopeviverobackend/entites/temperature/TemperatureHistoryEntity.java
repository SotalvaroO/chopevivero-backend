package co.edu.udea.chopeviverobackend.entites.temperature;

import javax.persistence.*;

@Entity
@Table(name = "tbl_temperature_time")
public class TemperatureHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor_id")
    private TemperatureSensorEntity sensor;

    private Double temperature;

}
