package co.edu.udea.chopeviverobackend.entites.radiation;

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
@Table(name = "tbl_radiation_time")
public class RadiationHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private RadiationSensorEntity sensor;

    private Double radiation;

    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    public RadiationHistoryEntity() {
        this.time = new Date();
    }

}
