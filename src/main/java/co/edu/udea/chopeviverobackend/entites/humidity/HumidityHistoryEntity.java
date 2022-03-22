package co.edu.udea.chopeviverobackend.entites.humidity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_humidity_time")
public class HumidityHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor_id")
    private HumiditySensorEntity sensor;

    private Double humidity;

}
