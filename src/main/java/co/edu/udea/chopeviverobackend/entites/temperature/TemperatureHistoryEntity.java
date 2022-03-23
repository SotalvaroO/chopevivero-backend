package co.edu.udea.chopeviverobackend.entites.temperature;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor

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

    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    public TemperatureHistoryEntity() {
        this.time = new Date();
    }
}
