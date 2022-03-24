package co.edu.udea.chopeviverobackend.entites.humidity;

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
@Table(name = "tbl_humidity_time")
public class HumidityHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private HumiditySensorEntity sensor;

    private Double humidity;

    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    public HumidityHistoryEntity() {
        this.time = new Date();
    }

}
