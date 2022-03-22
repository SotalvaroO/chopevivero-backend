package co.edu.udea.chopeviverobackend.entites.humidity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tbl_humidity_sensor")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HumiditySensorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serial;
    private String name;

}
