package co.edu.udea.chopeviverobackend.entites.radiation;

import javax.persistence.*;

@Entity
@Table(name = "tbl_radiation_time")
public class RadiationHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor_id")
    private RadiationSensorEntity sensor;

    private Double radiation;

}
