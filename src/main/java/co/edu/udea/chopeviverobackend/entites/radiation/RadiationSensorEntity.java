package co.edu.udea.chopeviverobackend.entites.radiation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tbl_radiation_sensor")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RadiationSensorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serial;
    private String name;

}
